package org.firstinspires.ftc.teamcode.sandbox.Day03IntakeServosSensors;





import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cColorSensor;
@TeleOp
public class Colin extends OpMode {
    Servo clawArm1;
    Servo clawArm2;
    Servo clawFolding;
    Servo droneLauncher;
    ModernRoboticsI2cColorSensor colorSensor;
    DcMotor redMostMotor;
    DcMotor greenMostMotor;
    DcMotor blueMostMotor;

@Override
    public void init() {
    colorSensor = hardwareMap.get(ModernRoboticsI2cColorSensor.class, "colorSensor");
    redMostMotor = hardwareMap.get(DcMotor.class, "redMostMotor");
    greenMostMotor = hardwareMap.get(DcMotor.class, "greenMostMotor");
    blueMostMotor = hardwareMap.get(DcMotor.class, "blueMostMotor");
    clawArm1 = hardwareMap.get(Servo.class, "clawArm1");
    clawArm2 = hardwareMap.get(Servo.class, "clawArm2");
    clawFolding = hardwareMap.get(Servo.class, "clawFolding");
    droneLauncher = hardwareMap.get(Servo.class, "droneLauncher");

}
    public void loop() {


//color sensor code
            colorSensor.getNormalizedColors();
            if (colorSensor.red() > colorSensor.blue() && colorSensor.red() > colorSensor.green()) {
                redMostMotor.setPower(1);
            } else if (colorSensor.green() > colorSensor.blue() && colorSensor.green() > colorSensor.red()) {
                greenMostMotor.setPower(1);
            } else {blueMostMotor.setPower(1);
            }
            }

        }

