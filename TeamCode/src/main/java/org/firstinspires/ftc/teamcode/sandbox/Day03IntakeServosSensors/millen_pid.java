package org.firstinspires.ftc.teamcode.sandbox.Day03IntakeServosSensors;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Config
@TeleOp
public class millen_pid extends OpMode{

    DcMotor motor1;
    public static double Kp = 0;
    public static double Ki = 0;
    double lastError = 0;
    double integralSum = 0;
    int TargetPos = 500;
    ElapsedTime timer;
    
    @Override
    public void init() {
        motor1 = hardwareMap.get(DcMotor.class, "motor1");
        timer = new ElapsedTime();
    }

    @Override
    public void loop() {
        int encoderPosition = motor1.getCurrentPosition();
        int error = TargetPos - encoderPosition;
        double derivative = ((error - lastError) / timer.seconds());
        integralSum += (error * timer.seconds());
        double out = ((Kp * error) + (Ki * integralSum));
        motor1.setPower(out);
        lastError = error;
        timer.reset();
        
    }
}
