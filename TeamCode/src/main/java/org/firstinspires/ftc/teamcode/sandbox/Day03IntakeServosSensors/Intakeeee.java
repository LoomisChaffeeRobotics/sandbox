package org.firstinspires.ftc.teamcode.sandbox.Day03IntakeServosSensors;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
@TeleOp
public class Intakeeee extends OpMode {
    DcMotor intake;
    ColorSensor colorSensor;

    public void init() {
        colorSensor = hardwareMap.get(ColorSensor.class, "colorSensor");
        intake = hardwareMap.get(DcMotor.class, "intake");
    }
    @Override
    public void loop() {
        if(gamepad1.x){
            intake.setPower(1);

        }
       else if(gamepad1.b){
            intake.setPower(-1);
        }
        else{
            intake.setPower(0);
        }
        if (colorSensor.red() > colorSensor.blue() && colorSensor.red() > colorSensor.green()) {
            intake.setPower(1.0);
        }
        else {
            intake.setPower(0);

        }
    }

}
