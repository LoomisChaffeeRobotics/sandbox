package org.firstinspires.ftc.teamcode.drive.opmode;

import android.util.Size;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.matrices.VectorF;

import org.firstinspires.ftc.robotcore.external.navigation.Pose3D;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagPoseFtc;
import org.firstinspires.ftc.vision.apriltag.AprilTagPoseRaw;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

import java.util.List;

@TeleOp
public class CameraHeadingTest extends OpMode {
    IMU imu;
    VisionPortal myVisionPortal;
    AprilTagProcessor myAprilTagProcessor;
    SampleMecanumDrive drive;
    @Override
    public void init() {
        drive = new SampleMecanumDrive(hardwareMap);
        imu = hardwareMap.get(IMU.class, "imu");
        myAprilTagProcessor = new AprilTagProcessor.Builder()
                .setDrawAxes(true)
                .setDrawTagID(true)
                .setDrawTagOutline(true)
                .setDrawCubeProjection(true)
                .setLensIntrinsics(996.968,996.968,929.592,530.676)
                .build();
        VisionPortal.Builder myVisionPortalBuilder = new VisionPortal.Builder();
        myVisionPortalBuilder.setCamera(hardwareMap.get(WebcamName.class, "Webcam 1"));
        myVisionPortalBuilder.addProcessor(myAprilTagProcessor);
        myVisionPortalBuilder.setCameraResolution(new Size(1920,1080));
        myVisionPortalBuilder.setStreamFormat(VisionPortal.StreamFormat.YUY2);
        myVisionPortalBuilder.enableLiveView(true);
        myVisionPortalBuilder.setAutoStopLiveView(true);
        myVisionPortal = myVisionPortalBuilder.build();

        drive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


    }

    @Override
    public void loop() {

        drive.setWeightedDrivePower(
                new Pose2d(
                        -gamepad1.left_stick_y,
                        -gamepad1.left_stick_x,
                        -gamepad1.right_stick_x
                )
        );


        Pose2d poseEstimate = drive.getPoseEstimate();

        List<AprilTagDetection> currentDetections = myAprilTagProcessor.getDetections();

        if(!currentDetections.isEmpty()){
            AprilTagDetection aprilTag1 = currentDetections.get(0);
            Pose3D cameraPos = aprilTag1.robotPose; // hopefully in inches
            double heading = Math.toRadians(cameraPos.getOrientation().getYaw()) +Math. PI;
            double x = cameraPos.getPosition().x;
            double y = cameraPos.getPosition().y;
            Pose2d poseRobot = new Pose2d(
                    x - 5.5 * Math.cos(heading), y - 5.5* Math.sin(heading),heading
            );
            drive.setPoseEstimate(poseRobot);



            telemetry.update();
        }
        drive.update();
    }
}
