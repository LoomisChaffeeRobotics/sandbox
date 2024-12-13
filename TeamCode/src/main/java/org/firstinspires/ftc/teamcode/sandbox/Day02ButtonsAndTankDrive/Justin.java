package org.firstinspires.ftc.teamcode.sandbox.Day02ButtonsAndTankDrive;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class Justin extends OpMode {
    Servo Wrist;
    Servo Claw;

    @Override
    public void init(){
        Wrist=hardwareMap.get(Servo.class,"Wrist");
        Claw=hardwareMap.get(Servo.class,"Claw");
    }
    @Override
    public void loop(){
        double wristlocation=0.00;
        double clawlocation=0.00;
        if(gamepad1.x){
            Wrist.setPosition(wristlocation+0.001);
        }
        else if(gamepad1.y){
            Wrist.setPosition(wristlocation-0.001);
        }
        else if(gamepad1.a){
            Claw.setPosition(clawlocation+0.001);
        }
        else if(gamepad1.b){
            Claw.setPosition(clawlocation-0.001);
        }
        telemetry.addLine("wrist position is: " + wristlocation);
        telemetry.addLine("claw position is: " + clawlocation);
        telemetry.update();
    }
}