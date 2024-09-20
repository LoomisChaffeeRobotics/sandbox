package org.firstinspires.ftc.teamcode.sandbox.Day03IntakeServosSensors;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
@TeleOp
public class a extends OpMode {
    DcMotor motor1;

    @Override
    public void init() {
        motor1 = hardwareMap.get(DcMotor.class, "buttonX");

    }

    @Override
    public void loop() {

        if (gamepad1.x) {
            motor1.setPower(1);

        } else if (gamepad1.b) {
            motor1.setPower(-1);

        } else {
            motor1.setPower(0);
        }
    }

}