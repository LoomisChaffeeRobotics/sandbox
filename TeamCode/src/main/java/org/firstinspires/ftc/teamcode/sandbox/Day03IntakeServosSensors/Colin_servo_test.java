package org.firstinspires.ftc.teamcode.sandbox.Day03IntakeServosSensors;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class Colin_servo_test extends OpMode {
    Servo ClawR;
    Servo ClawL;
    Servo Wrist;
    Servo Launcher;
    @Override
    public void init() {
        ClawR = hardwareMap.get(Servo.class, "ClawR");
        ClawL = hardwareMap.get(Servo.class, "ClawL");
        Wrist = hardwareMap.get(Servo.class, "Wrist");
        Launcher = hardwareMap.get(Servo.class, "Launcher");

    }

    public void loop() {
        if (gamepad1.dpad_right) {
            ClawR.setPosition(ClawR.getPosition() + 0.01);
            telemetry.addData("ClawR Position", ClawR.getPosition());
        }
        if (gamepad1.dpad_left) {
            ClawR.setPosition(ClawR.getPosition() - 0.01);
            telemetry.addData("ClawR Position", ClawR.getPosition());
        }
        if (gamepad1.dpad_up) {
            ClawL.setPosition(ClawL.getPosition() + 0.01);
            telemetry.addData("ClawL Position", ClawL.getPosition());
        }
        if (gamepad1.dpad_down) {
            ClawL.setPosition(ClawL.getPosition() - 0.01);
            telemetry.addData("ClawL Position", ClawL.getPosition());
        }
        if (gamepad1.a) {
            Wrist.setPosition(Wrist.getPosition() + 0.01);
            telemetry.addData("Wrist Position", Wrist.getPosition());
        }
        if (gamepad1.b) {
            Wrist.setPosition(Wrist.getPosition() - 0.01);
            telemetry.addData("Wrist Position", Wrist.getPosition());
        }
        if (gamepad1.x) {
            Launcher.setPosition(Launcher.getPosition() + 0.01);
            telemetry.addData("Launcher Position", Launcher.getPosition());
        }
        if (gamepad1.y) {
            Launcher.setPosition(Launcher.getPosition() - 0.01);
            telemetry.addData("Launcher Position", Launcher.getPosition());
        }


    }

}
