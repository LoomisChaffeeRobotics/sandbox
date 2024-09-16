package org.firstinspires.ftc.teamcode.examples;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class example extends OpMode {

    DcMotor motor1;
    public void init() {
        motor1 = hardwareMap.get(DcMotor.class, "motor1");
    }

    public void loop () {
        motor1.setPower(.375);
    }
}
