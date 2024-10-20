package org.firstinspires.ftc.teamcode.examples;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp(group = "Day1")
public class Day01_Motor extends OpMode {
    DcMotor motor1;
    @Override
    public void init() {
        motor1 = hardwareMap.get(DcMotor.class, "motor1");
    }

    @Override
    public void loop() {
        motor1.setPower(1);
        telemetry.addData("Motor Power", motor1.getPower());
        telemetry.update();
    }
}
