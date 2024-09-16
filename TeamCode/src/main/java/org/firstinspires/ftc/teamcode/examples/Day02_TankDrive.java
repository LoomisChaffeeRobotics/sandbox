package org.firstinspires.ftc.teamcode.examples;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(group = "Day02")
public class Day02_TankDrive extends OpMode {
    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor rearLeft;
    DcMotor rearRight;
    @Override
    public void init() {
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        rearLeft = hardwareMap.get(DcMotor.class, "rearLeft");
        rearRight = hardwareMap.get(DcMotor.class, "rearRight");
    }

    @Override
    public void loop() {
        frontLeft.setPower(gamepad1.left_stick_y);
        rearLeft.setPower(gamepad1.left_stick_y);
        rearRight.setPower(gamepad1.right_stick_y);
        frontRight.setPower(gamepad1.right_stick_y);
    }
}
