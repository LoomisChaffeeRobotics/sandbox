package org.firstinspires.ftc.teamcode.drive.opmode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.Pose3D;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequenceRunner;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

import java.util.List;

/**
 * This is a simple teleop routine for testing localization. Drive the robot around like a normal
 * teleop routine and make sure the robot's estimated pose matches the robot's actual pose (slight
 * errors are not out of the ordinary, especially with sudden drive motions). The goal of this
 * exercise is to ascertain whether the localizer has been configured properly (note: the pure
 * encoder localizer heading may be significantly off if the track width has not been tuned).
 */
@TeleOp(group = "drive")
public class LocalTestModed extends LinearOpMode {
    AprilTagProcessor myAprilTagProcessor;
    VisionPortal myVisionPortal;
    SampleMecanumDrive drive;
    TrajectorySequenceRunner trajectorySequenceRunner;
    int visionCounter; // TODO set this up with vision portal to not run each tick

    @Override
    public void runOpMode() throws InterruptedException {
        drive = new SampleMecanumDrive(hardwareMap);
        myAprilTagProcessor = AprilTagProcessor.easyCreateWithDefaults();
        myVisionPortal = VisionPortal.easyCreateWithDefaults(hardwareMap.get(WebcamName.class, "Webcam 1"), myAprilTagProcessor);


        drive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        waitForStart();

        trajectorySequenceRunner = drive.trajectorySequenceRunner;

        while (!isStopRequested()) {
            drive.setWeightedDrivePower(
                    new Pose2d(
                            -gamepad1.left_stick_y,
                            -gamepad1.left_stick_x,
                            -gamepad1.right_stick_x
                    )
            );

            drive.update();

            Pose2d poseEstimate = drive.getPoseEstimate();
            telemetry.addData("x", poseEstimate.getX());
            telemetry.addData("y", poseEstimate.getY());
            telemetry.addData("heading", poseEstimate.getHeading());
            telemetry.addData("AprilTags Detected", myAprilTagProcessor.getDetections());
            telemetry.update();

            List<AprilTagDetection> currentDetections = myAprilTagProcessor.getDetections();
            if (!currentDetections.isEmpty()) {
                AprilTagDetection aprilTag1 = currentDetections.get(0);
                Pose3D calculatedPose = aprilTag1.robotPose;
                Pose2d aprilTagPoseEstimate = new Pose2d(calculatedPose.getPosition().x,
                        calculatedPose.getPosition().y,
                        calculatedPose.getOrientation().getYaw());
                trajectorySequenceRunner.update(aprilTagPoseEstimate,drive.getPoseVelocity());
            }
        }
    }
}

