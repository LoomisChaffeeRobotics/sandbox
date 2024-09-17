package org.firstinspires.ftc.teamcode.sandbox.Day02ButtonsAndTankDrive;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class Opmode extends OpMode {
DcMotor frontLeft;
DcMotor frontRight;
DcMotor rearLeft;
DcMotor rearRight;

    @Override
    public void init() {
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        rearLeft = hardwareMap.get(DcMotor.class, "rearLeft");
        rearRight = hardwareMap.get(DcMotor.class, "rearRight");
    }


    @Override
    public void loop() {

            frontLeft.setPower(gamepad1.left_stick_y);
            frontRight.setPower(gamepad1.right_stick_y);
            rearLeft.setPower(gamepad1.right_stick_y);
            rearRight.setPower(gamepad1.right_stick_y);



    }
}
