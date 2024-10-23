package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.RevIMU;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.arcrobotics.ftclib.hardware.motors.MotorGroup;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

public class DriveSubsystem extends SubsystemBase {
    private final MotorEx leftBack, leftFront, rightBack, rightFront;
    private final MotorGroup motors;
    private final IMU imu;

    public DriveSubsystem(final HardwareMap hMap, final String leftBack, String leftFront, String rightBack, String rightFront, final Motor.GoBILDA rpm, IMU imu){
        this.leftBack = new MotorEx(hMap, leftBack, rpm);
        this.leftFront = new MotorEx(hMap, leftFront, rpm);
        this.rightBack = new MotorEx(hMap, rightBack, rpm);
        this.rightFront = new MotorEx(hMap, rightFront, rpm);

        motors = new MotorGroup(this.leftBack, this.leftFront, this.rightBack, this.rightFront);

        this.imu = imu;
    }

    public void setMotors(double leftBackSpeed, double leftFrontSpeed, double rightBackSpeed, double rightFrontSpeed, Motor.RunMode runMode){
        motors.setRunMode(runMode);
        leftBack.setVelocity(leftBackSpeed);
        leftFront.setVelocity(leftFrontSpeed);
        rightBack.setVelocity(rightBackSpeed);
        rightFront.setVelocity(rightFrontSpeed);
    }
}
