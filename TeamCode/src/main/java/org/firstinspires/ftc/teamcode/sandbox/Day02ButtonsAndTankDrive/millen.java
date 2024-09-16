package org.firstinspires.ftc.teamcode.sandbox.Day02ButtonsAndTankDrive;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class millen extends OpMode {

    DcMotor fl;
    DcMotor fr;
    DcMotor rl;
    DcMotor rr;

    @Override
    public void init() {
        fl = hardwareMap.get(DcMotor.class, "frontLeft");
        fr = hardwareMap.get(DcMotor.class, "frontRight");
        rl = hardwareMap.get(DcMotor.class, "rearLeft");
        rr = hardwareMap.get(DcMotor.class, "rearRight");
    }

    @Override
    public void loop() {
        fl.setPower(gamepad1.left_stick_y);
        rl.setPower(gamepad1.left_stick_y);
        fr.setPower(gamepad1.right_stick_y);
        rr.setPower(gamepad1.right_stick_y);
    }
}

/*

public volatile float left_stick_y = 0f;

public volatile float right_stick_y = 0f;
 */