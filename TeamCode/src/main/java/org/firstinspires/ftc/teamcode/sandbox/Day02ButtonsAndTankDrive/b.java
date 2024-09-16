package org.firstinspires.ftc.teamcode.sandbox.Day02ButtonsAndTankDrive;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class b extends OpMode {
    DcMotor frontRight;
    DcMotor frontLeft;
    DcMotor backRight;
    DcMotor backLeft;
    @Override
    public void init() {
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
    }
    DcMotor.Direction
    @Override
    public void loop() {

    }
}
