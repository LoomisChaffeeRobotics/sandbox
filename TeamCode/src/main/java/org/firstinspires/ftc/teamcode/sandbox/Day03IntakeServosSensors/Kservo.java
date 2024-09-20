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
            ClawL.setPosition(ClawL.getPosition() + 0.55);
        }
      if (gamepad1.dpad_right) {
          ClawR.setPosition(ClawR.getPosition() + 0.55);
      }
      if (gamepad1.a) {
          Wrist.setPosition(Wrist.getPosition() + 0.55);
      }
      if (gamepad1.b) {
          Hook.setPosition(Hook.getPosition() + 0.55);
      }
      if (gamepad1.x) {
          Launcher.setPosition(Launcher.getPosition() + 0.55);
      }

        if (gamepad1.left_bumper) {
            ClawL.setPosition(ClawL.getPosition() - 0.55);
        }
        if (gamepad1.right_bumper) {
            ClawR.setPosition(ClawR.getPosition() - 0.55);
        }
        if (gamepad1.dpad_down) {
            Wrist.setPosition(Wrist.getPosition() - 0.55);
        }
        if (gamepad1.dpad_up) {
            Hook.setPosition(Hook.getPosition() - 0.55);
        }
        if (gamepad1.touchpad) {
            Launcher.setPosition(Launcher.getPosition() - 0.55);
        }
    }


}
