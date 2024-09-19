package org.firstinspires.ftc.teamcode.sandbox.Day03IntakeServosSensors;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cColorSensor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class millen extends OpMode {

    Servo ClawR;
    Servo ClawL;
    Servo Wrist;
    Servo Extra1;
    Servo Extra2;

    @Override
    public void init() {
        ClawR = hardwareMap.get(Servo.class, "Servo0");
        ClawL = hardwareMap.get(Servo.class, "Servo1");
        Wrist = hardwareMap.get(Servo.class, "Servo2");
        Extra1 = hardwareMap.get(Servo.class, "Servo3");
        Extra2 = hardwareMap.get(Servo.class, "Servo4");
    }

    @Override
    public void loop() {
        if (gamepad1.dpad_right) {
            ClawR.setPosition(0.5);
        }
        if (gamepad1.dpad_left) {
            ClawL.setPosition(0.5);
        }
        if (gamepad1.dpad_up) {
            Wrist.setPosition(0.5);
        }
        if (gamepad1.dpad_down) {
            Extra1.setPosition(0.5);
        }
        if (gamepad1.start) {
            Extra2.setPosition(0.5);
        }



    }
}

/*

public volatile float left_stick_y = 0f;

public volatile float right_stick_y = 0f;
 */