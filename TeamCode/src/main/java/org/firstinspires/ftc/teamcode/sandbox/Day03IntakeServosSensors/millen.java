package org.firstinspires.ftc.teamcode.sandbox.Day03IntakeServosSensors;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cColorSensor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class millen extends OpMode {

    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor rearLeft;
    DcMotor rearRight;
    Servo ClawR;
    Servo ClawL;
    Servo Wrist;
    Servo Hook;
    Servo Launcher;
    float speedfactor = 0.001F;
    float ClawRdef = 0.7412F;
    float ClawLdef = 0.7367F;
    float Wristdef = 0.0F;
    float Hookdef = 0.9057F;


    @Override
    public void init() {
        ClawR = hardwareMap.get(Servo.class, "ClawR");

        ClawL = hardwareMap.get(Servo.class, "ClawL");
        Wrist = hardwareMap.get(Servo.class, "Wrist");
        Hook = hardwareMap.get(Servo.class, "Hook");

        Launcher = hardwareMap.get(Servo.class, "Launcher");

        ClawR.setPosition(ClawRdef);
        ClawL.setPosition(ClawLdef);
        Wrist.setPosition(Wristdef);
        Hook.setPosition(Hookdef);

        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        rearLeft = hardwareMap.get(DcMotor.class, "rearLeft");
        rearRight = hardwareMap.get(DcMotor.class, "rearRight");
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        rearRight.setDirection(DcMotorSimple.Direction.REVERSE);
        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rearLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rearRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    @Override
    public void loop() {
        frontLeft.setPower(gamepad1.left_stick_y);
        rearLeft.setPower(gamepad1.left_stick_y);
        frontRight.setPower(gamepad1.right_stick_y);
        rearRight.setPower(gamepad1.right_stick_y);

        // Dpad R/L - ClawR
        // Dpad U/D - ClawL
        // Y/A - Wrist
        // XB - Hook
        // Bumbers - Launcher
        if(gamepad1.back){
            ClawR.setPosition(ClawRdef);
            ClawL.setPosition(ClawLdef);
            Wrist.setPosition(Wristdef);
            Hook.setPosition(Hookdef);
        }

        if (gamepad1.dpad_right && !gamepad1.left_bumper) {
            ClawR.setPosition(0.5297);
            telemetry.addData("ClawR Pos:", (ClawR.getPosition()));
        }
        if (gamepad1.dpad_left && !gamepad1.left_bumper) {
            ClawR.setPosition(ClawRdef);
            telemetry.addData("ClawR Pos:", (ClawR.getPosition()));
        }
        if (gamepad1.dpad_up && !gamepad1.left_bumper) {
            ClawL.setPosition(0.9730);
            telemetry.addData("ClawL Pos:", (ClawL.getPosition()));
        }
        if (gamepad1.dpad_down && !gamepad1.left_bumper) {
            ClawL.setPosition(ClawLdef);
            telemetry.addData("ClawL Pos:", (ClawL.getPosition()));
        }
        if (gamepad1.y && !gamepad1.left_bumper) {
            Wrist.setPosition(1.0);
            telemetry.addData("Wrist Pos:", (Wrist.getPosition()));
        }
        if (gamepad1.a && !gamepad1.left_bumper) {
            Wrist.setPosition(Wristdef);
            telemetry.addData("Wrist Pos:", (Wrist.getPosition()));
        }
        if (gamepad1.x && !gamepad1.left_bumper) {
            Hook.setPosition(Hookdef);
            telemetry.addData("Hook Pos:", (Hook.getPosition()));
        }
        if (gamepad1.b && !gamepad1.left_bumper) {
            Hook.setPosition(0.4844);
            telemetry.addData("Hook Pos:", (Hook.getPosition()));
        }



        if (gamepad1.dpad_right && gamepad1.left_bumper) {
            ClawR.setPosition(ClawR.getPosition() - speedfactor);
            telemetry.addData("ClawR Pos:", (ClawR.getPosition()));
        }
        if (gamepad1.dpad_left && gamepad1.left_bumper) {
            ClawR.setPosition(ClawR.getPosition() + speedfactor);
            telemetry.addData("ClawR Pos:", (ClawR.getPosition()));
        }
        if (gamepad1.dpad_up && gamepad1.left_bumper) {
            ClawL.setPosition(ClawL.getPosition() + speedfactor);
            telemetry.addData("ClawL Pos:", (ClawL.getPosition()));
        }
        if (gamepad1.dpad_down && gamepad1.left_bumper) {
            ClawL.setPosition(ClawL.getPosition() - speedfactor);
            telemetry.addData("ClawL Pos:", (ClawL.getPosition()));
        }
        if (gamepad1.y && gamepad1.left_bumper) {
            Wrist.setPosition(Wrist.getPosition() + speedfactor);
            telemetry.addData("Wrist Pos:", (Wrist.getPosition()));
        }
        if (gamepad1.a && gamepad1.left_bumper) {
            Wrist.setPosition(Wrist.getPosition() - speedfactor);
            telemetry.addData("Wrist Pos:", (Wrist.getPosition()));
        }
        if (gamepad1.x && gamepad1.left_bumper) {
            Hook.setPosition(Hook.getPosition() - speedfactor);
            telemetry.addData("Hook Pos:", (Hook.getPosition()));
        }
        if (gamepad1.b && gamepad1.left_bumper) {
            Hook.setPosition(Hook.getPosition() + speedfactor);
            telemetry.addData("Hook Pos:", (Hook.getPosition()));
        }
        /*
        if (gamepad1.left_bumper) {
            Launcher.setPosition(Launcher.getPosition() - speedfactor);
            telemetry.addData("Launcher Pos:", (Launcher.getPosition()));
        }
        if (gamepad1.b) {
            Launcher.setPosition(Launcher.getPosition() - speedfactor);
            telemetry.addData("Launcher Pos:", (Launcher.getPosition()));
        } */

        }



    }

/*

public volatile float left_stick_y = 0f;

public volatile float right_stick_y = 0f;
 */