package org.firstinspires.ftc.teamcode.drive.opmode;

import android.util.Size;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.IMU;

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
    IMU imu;
    AprilTagProcessor myAprilTagProcessor;
    VisionPortal myVisionPortal;
    VisionPortal.Builder myVisionPortalBuilder;
    SampleMecanumDrive drive;
    TrajectorySequenceRunner trajectorySequenceRunner;
    Pose2d aprilTagPoseEstimate= new Pose2d(0,0,0);
    Pose2d poseError = new Pose2d(0,0,0);

    int visionCounter; // TODO set this up with vision portal to not run each tick

    @Override
    public void runOpMode() throws InterruptedException {
        drive = new SampleMecanumDrive(hardwareMap);
        imu = hardwareMap.get(IMU.class, "imu");
        myAprilTagProcessor = new AprilTagProcessor.Builder()
                .setDrawAxes(true)
                .setDrawTagID(true)
                .setDrawTagOutline(true)
                .setDrawCubeProjection(true)
                .setLensIntrinsics(996.968,996.968,929.592, 530.676)
                .build();
        // Create a new VisionPortal Builder object.
        myVisionPortalBuilder = new VisionPortal.Builder();

// Specify the camera to be used for this VisionPortal.
        myVisionPortalBuilder.setCamera(hardwareMap.get(WebcamName.class, "Webcam 1"));      // Other choices are: RC phone camera and "switchable camera name".

// Add the AprilTag Processor to the VisionPortal Builder.
        myVisionPortalBuilder.addProcessor(myAprilTagProcessor);       // An added Processor is enabled by default.

// Optional: set other custom features of the VisionPortal (4 are shown here).
        myVisionPortalBuilder.setCameraResolution(new Size(1920, 1080));  // Each resolution, for each camera model, needs calibration values for good pose estimation.
        myVisionPortalBuilder.setStreamFormat(VisionPortal.StreamFormat.YUY2);  // MJPEG format uses less bandwidth than the default YUY2.
        myVisionPortalBuilder.enableLiveView(true);      // Enable LiveView (RC preview).
        myVisionPortalBuilder.setAutoStopLiveView(true);     // Automatically stop LiveView (RC preview) when all vision processors are disabled.

// Create a VisionPortal by calling build()
        myVisionPortal = myVisionPortalBuilder.build();
        drive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
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
            telemetry.addData("x", aprilTagPoseEstimate.getX());
            telemetry.addData("y", aprilTagPoseEstimate.getY());
            telemetry.addData("heading", Math.toDegrees(imu.getRobotYawPitchRollAngles().getYaw()));
            telemetry.addData("AprilTags Detected", myAprilTagProcessor.getDetections());
            telemetry.update();

            List<AprilTagDetection> currentDetections = myAprilTagProcessor.getDetections();

            if (!currentDetections.isEmpty()) {
                AprilTagDetection aprilTag1 = currentDetections.get(0);
                Pose3D calculatedPose = aprilTag1.robotPose;
                 aprilTagPoseEstimate = new Pose2d(calculatedPose.getPosition().x,
                        calculatedPose.getPosition().y,
                        Math.toRadians(imu.getRobotYawPitchRollAngles().getYaw()));
                poseError = drive.getPoseEstimate().minus(aprilTagPoseEstimate);
                drive.setPoseEstimate(aprilTagPoseEstimate);


            }




        }

    }
}


