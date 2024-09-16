package org.firstinspires.ftc.teamcode.examples;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class Day03SpinningIntake extends OpMode {
    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor rearLeft;
    DcMotor rearRight;
    DcMotor motor1;
    @Override
    public void init() {
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        rearLeft = hardwareMap.get(DcMotor.class, "rearLeft");
        rearRight = hardwareMap.get(DcMotor.class, "rearRight");
        motor1 = hardwareMap.get(DcMotor.class, "motor1");
    }

    @Override
    public void loop() {
        frontLeft.setPower(gamepad1.left_stick_y);
        rearLeft.setPower(gamepad1.left_stick_y);
        rearRight.setPower(gamepad1.right_stick_y);
        frontRight.setPower(gamepad1.right_stick_y);

        if (gamepad1.a) {
            motor1.setPower(1);
        } else if (gamepad1.x) {
            motor1.setPower(0);
        } else if (gamepad1.y) {
            motor1.setPower(-1);
        }
    }
}
