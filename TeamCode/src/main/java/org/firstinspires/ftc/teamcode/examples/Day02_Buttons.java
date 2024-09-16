package org.firstinspires.ftc.teamcode.examples;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class Day02_Buttons extends OpMode {
    DcMotor motor1;
    @Override
    public void init() {
        motor1 = hardwareMap.get(DcMotor.class, "motor1");
    }

    @Override
    public void loop() {
        if (gamepad1.a) {
            motor1.setPower(1);
        } else {
            motor1.setPower(0);
        }
        telemetry.addData("Motor Power", motor1.getPower());
        telemetry.addData("Is A pressed?", gamepad1.a);
        telemetry.update();
    }
}
