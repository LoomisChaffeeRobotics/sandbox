package org.firstinspires.ftc.teamcode.examples;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;



public class Day01_Motor extends OpMode {
    DcMotor intake;
    @Override
    public void init() {
        intake = hardwareMap.get(DcMotor.class, "intake");

    }

    @Override
    public void loop() {

    }
}
