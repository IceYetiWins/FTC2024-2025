package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.arcrobotics.ftclib.hardware.motors.MotorGroup;
import com.qualcomm.robotcore.hardware.IMU;

public class DriveSubsystem extends SubsystemBase {
    private final MotorEx leftBack, leftFront, rightBack, rightFront;
    private final MotorGroup motors;
    private final IMU imu;

    public DriveSubsystem(MotorEx leftBack, MotorEx leftFront, MotorEx rightBack, MotorEx rightFront, IMU imu){
        this.leftBack = leftBack;
        this.leftFront = leftFront;
        this.rightBack = rightBack;
        this.rightFront = rightFront;

        motors = new MotorGroup(this.leftBack, this.leftFront, this.rightBack, this.rightFront);

        this.imu = imu;
    }

    public void setMotors(double leftBackSpeed, double leftFrontSpeed, double rightBackSpeed, double rightFrontSpeed, Motor.RunMode runMode){
        motors.setRunMode(runMode);
        leftBack.setVelocity(leftBackSpeed * 1000);
        leftFront.setVelocity(leftFrontSpeed * 1000);
        rightBack.setVelocity(rightBackSpeed * 1000);
        rightFront.setVelocity(rightFrontSpeed * 1000);
    }

    public void initializeIMU(IMU.Parameters parameters){
        imu.initialize(parameters);
    }
}
