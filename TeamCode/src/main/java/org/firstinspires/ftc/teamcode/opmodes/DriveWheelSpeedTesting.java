package org.firstinspires.ftc.teamcode.opmodes;

import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class DriveWheelSpeedTesting extends OpMode {
    private int lastLeftBackPosition = 0, lastLeftFrontPosition = 0, lastRightBackPosition = 0, lastRightFrontPosition = 0;
    private long lastTime = System.currentTimeMillis();
    private MotorEx leftBack, leftFront, rightBack, rightFront;

    @Override
    public void init(){
        leftBack = new MotorEx(hardwareMap, "leftBack", Motor.GoBILDA.RPM_435);
        leftBack.setRunMode(Motor.RunMode.RawPower);
        leftFront = new MotorEx(hardwareMap, "leftFront", Motor.GoBILDA.RPM_435);
        leftFront.setRunMode(Motor.RunMode.RawPower);
        rightBack = new MotorEx(hardwareMap, "rightBack", Motor.GoBILDA.RPM_435);
        rightBack.setRunMode(Motor.RunMode.RawPower);
        rightFront = new MotorEx(hardwareMap, "rightFront", Motor.GoBILDA.RPM_435);
        rightFront.setRunMode(Motor.RunMode.RawPower);
    }

    @Override
    public void loop(){
        leftBack.set(1);
        leftFront.set(1);
        rightBack.set(1);
        rightFront.set(1);

        long currentTime = System.currentTimeMillis();
        double deltaTime = (currentTime - lastTime) / 1000.0;

        int leftBackPosition = leftBack.getCurrentPosition();
        int leftFrontPosition = leftFront.getCurrentPosition();
        int rightBackPosition = rightBack.getCurrentPosition();
        int rightFrontPosition = rightFront.getCurrentPosition();

        telemetry.addData("Left back speed (tps)", (leftBackPosition - lastLeftBackPosition) / deltaTime);
        telemetry.addData("Left front speed (tps)", (leftFrontPosition - lastLeftFrontPosition) / deltaTime);
        telemetry.addData("Right back speed (tps)", (rightBackPosition - lastRightBackPosition) / deltaTime);
        telemetry.addData("Right front speed (tps)", (rightFrontPosition - lastRightFrontPosition) / deltaTime);
        telemetry.update();

        lastLeftBackPosition = leftBackPosition;
        lastLeftFrontPosition = leftFrontPosition;
        lastRightBackPosition = rightBackPosition;
        lastRightFrontPosition = rightFrontPosition;
        lastTime = currentTime;
    }
}
