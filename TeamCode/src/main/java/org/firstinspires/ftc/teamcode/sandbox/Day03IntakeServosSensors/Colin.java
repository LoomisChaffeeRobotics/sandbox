package org.firstinspires.ftc.teamcode.sandbox.Day03IntakeServosSensors;

import android.hardware.Sensor;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cColorSensor;
@TeleOp
public class Colin extends OpMode {
    Servo servo1;
    ModernRoboticsI2cColorSensor colorSensor;
    DcMotor redMostMotor;
    DcMotor greenMostMotor;
    DcMotor blueMostMotor;
@Override
    public void init() {
    redMostMotor = hardwareMap.get(DcMotor.class, "redMostMotor");
    greenMostMotor = hardwareMap.get(DcMotor.class, "greenMostMotor");
    blueMostMotor = hardwareMap.get(DcMotor.class, "blueMostMotor");
}
    public void loop() {
            colorSensor.getNormalizedColors();
            if (colorSensor.red() > colorSensor.blue() && colorSensor.red() > colorSensor.green()) {
                redMostMotor.setPower(1);
            } else if (colorSensor.green() > colorSensor.blue() && colorSensor.green() > colorSensor.red()) {
                greenMostMotor.setPower(1);
            } else {blueMostMotor.setPower(1);
            }
            }

        }

