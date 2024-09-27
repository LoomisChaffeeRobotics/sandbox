package org.firstinspires.ftc.teamcode.sandbox.Day03IntakeServosSensors;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Config
@TeleOp
public class millen_pid extends OpMode{

    DcMotor motor1;
    public static double Kd = 1e-4;
    public static double Kp = 3.5e-3;
    public static double Ki = 4e-5;
    public static double Kf = 2.5e-1;
    double lastError = 0;
    double integralSum = 0;
    public static int TargetPos = 200;
    ElapsedTime timer;
    FtcDashboard dashboard;

    
    @Override
    public void init() {
        motor1 = hardwareMap.get(DcMotor.class, "motor1");
        timer = new ElapsedTime();
        dashboard = FtcDashboard.getInstance();
        telemetry = dashboard.getTelemetry();
    }

    @Override
    public void loop() {
        int encoderPosition = motor1.getCurrentPosition();
        int error = TargetPos - encoderPosition;
        double derivative = ((error - lastError) / timer.seconds());
        integralSum += (error * timer.seconds());
        double feedForward = Math.cos(Math.toRadians(motor1.getCurrentPosition()*360/1425));
        double out = ((Kp * error) + (Ki * integralSum) + (-Kf * feedForward) + (Kd * derivative));
        motor1.setPower(out);
        lastError = error;
        timer.reset();
        telemetry.addData("Position:", motor1.getCurrentPosition());
        telemetry.addData("Target Pos:", TargetPos);
        telemetry.addData("Motor power", out);
        telemetry.update();
        
    }
}
