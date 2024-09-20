package org.firstinspires.ftc.teamcode.sandbox.Day03IntakeServosSensors;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class Kservo extends OpMode {
    Servo ClawR;
    Servo ClawL;
    Servo Wrist;
    Servo Hook;
    Servo Launcher;

    @Override
    public void init() {
        ClawR= hardwareMap.get(Servo.class, "ClawR");
        ClawL= hardwareMap.get(Servo.class, "ClawL");
        Wrist= hardwareMap.get(Servo.class, "Wrist");
        Hook= hardwareMap.get(Servo.class, "Hook");
        Launcher= hardwareMap.get(Servo.class, "Launcher");
    }

    @Override
    public void loop() {

         if (gamepad1.dpad_left) {
             ClawL.setPosition(0.5);
         }
        if (gamepad1.dpad_right) {
            ClawR.setPosition(0.5);
        }
        if (gamepad1.a) {
            Wrist.setPosition(0.5);
        }
        if (gamepad1.x) {
            Hook.setPosition(0.5);
        }
        if (gamepad1.b) {
            Launcher.setPosition(0.5);
        }
    }


}
