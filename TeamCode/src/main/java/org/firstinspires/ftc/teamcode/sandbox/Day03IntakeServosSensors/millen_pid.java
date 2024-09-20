package org.firstinspires.ftc.teamcode.sandbox.Day03IntakeServosSensors;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@Config
@TeleOp
public class millen_pid extends OpMode{

    DcMotor motor1;

    @Override
    public void init() {
        motor1 = hardwareMap.get(DcMotor.class, "motor1");
    }

    @Override
    public void loop() {

    }
}
