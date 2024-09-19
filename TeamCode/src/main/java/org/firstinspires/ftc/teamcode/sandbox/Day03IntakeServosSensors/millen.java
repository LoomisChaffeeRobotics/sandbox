package org.firstinspires.ftc.teamcode.sandbox.Day03IntakeServosSensors;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cColorSensor;

@TeleOp
public class millen extends OpMode {

    ModernRoboticsI2cColorSensor CSensor;

    @Override
    public void init() {
        CSensor = hardwareMap.get(ModernRoboticsI2cColorSensor.class, "ColorSensor");
    }

    @Override
    public void loop() {
        if (CSensor.blue() > CSensor.green() && CSensor.blue() > CSensor.red()) {

        }

    }
}

/*

public volatile float left_stick_y = 0f;

public volatile float right_stick_y = 0f;
 */