package org.firstinspires.ftc.teamcode.sandbox.Day02ButtonsAndTankDrive;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

public class lolcode {
    DcMotor frontleft;
    DcMotor frontright;
    DcMotor rearleft;
    DcMotor rearright;
    Gamepad gamepad;
    @Override
    public void init(){
        frontleft = hardwareMap.get(DcMotor.class,"frontleft");
        frontright = hardwareMap.get(DcMotor.class,"frontright");
        rearleft = hardwareMap.get(DcMotor.class,"rearleft");
        rearright = hardwareMap.get(DcMotor.class,"rearright");

        if(gamepad.right_bumper)
    }
    @Override
    public void loop(){

    }
}
