package org.firstinspires.ftc.teamcode.drive.opmode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

import java.util.List;


@TeleOp
public class cameraThing extends OpMode {

    IMU imu;
    AprilTagProcessor myAprilTagProcessor;
    VisionPortal myVisionPortal;
    SampleMecanumDrive drive;

    @Override
    public void init() {
        drive  = new SampleMecanumDrive(hardwareMap);

        imu = hardwareMap.get(IMU.class, "imu");
// Create the AprilTag processor and assign it to a variable.
        myAprilTagProcessor = AprilTagProcessor.easyCreateWithDefaults();
        // Enable or disable the AprilTag processor.
        myVisionPortal = VisionPortal.easyCreateWithDefaults(hardwareMap.get(WebcamName.class, "Webcam 1"), myAprilTagProcessor);

    }

    @Override
    public void loop() {
        aprilTagTelemetry();
        telemetry.addData("pose",drive.getPoseEstimate());
        drive.update();
    }
    private void aprilTagTelemetry() {
        List<AprilTagDetection> currentDetections = myAprilTagProcessor.getDetections();
        telemetry.addData("# AprilTags Detected", currentDetections.size());

        // Step through the list of detections and display info for each one.
        for (AprilTagDetection detection : currentDetections) {

            // targetTag isolated

            telemetry.addLine(String.format("\n==== (ID %d) %s", detection.id, detection.metadata.name));
            telemetry.addLine(String.format("XYZ %6.1f %6.1f %6.1f  (inch)", detection.ftcPose.x, detection.ftcPose.y, detection.ftcPose.z));
            telemetry.addLine(String.format("PRY %6.1f %6.1f %6.1f  (deg)", detection.ftcPose.pitch, detection.ftcPose.roll, detection.ftcPose.yaw));
            telemetry.addLine(String.format("RBE %6.1f %6.1f %6.1f  (inch, deg, deg)", detection.ftcPose.range, detection.ftcPose.bearing, detection.ftcPose.elevation));


        }


    }
    private void aprilTagRobotPosition() {
        List<AprilTagDetection> currentDetections = myAprilTagProcessor.getDetections();
        if (!currentDetections.isEmpty()) {
            AprilTagDetection aprilTag1 = currentDetections.get(1);
             double rotatedPerceivedRobotPosX = -Math.sin(aprilTag1.ftcPose.x) + Math.cos(aprilTag1.ftcPose.y);
             double rotatedPerceivedRobotPosY = Math.cos(aprilTag1.ftcPose.x) + Math.sin(aprilTag1.ftcPose.y);
            double realPositionX = aprilTag1.rawPose.x - rotatedPerceivedRobotPosX;
            double realPositionY = aprilTag1.rawPose.y - rotatedPerceivedRobotPosY;
            telemetry.addData("realPositionX", realPositionX);
            telemetry.addData("realPositionY", realPositionY);

        }



    }
}
