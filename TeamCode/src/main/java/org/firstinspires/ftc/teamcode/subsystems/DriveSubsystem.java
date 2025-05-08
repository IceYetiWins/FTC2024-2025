package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.arcrobotics.ftclib.hardware.motors.MotorGroup;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class DriveSubsystem extends SubsystemBase {
    private final MotorEx leftBack, leftFront, rightBack, rightFront;
    private final MotorGroup motors;
    private final IMU imu;
    private final Telemetry telemetry;

    public DriveSubsystem(MotorEx leftBack, MotorEx leftFront, MotorEx rightBack, MotorEx rightFront, IMU imu, Telemetry telemetry){
        this.leftBack = leftBack;
        this.leftFront = leftFront;
        this.rightBack = rightBack;
        this.rightFront = rightFront;

        motors = new MotorGroup(this.leftBack, this.leftFront, this.rightBack, this.rightFront);

        this.imu = imu;
        this.telemetry = telemetry;
    }

    public void setMotors(double leftBackSpeed, double leftFrontSpeed, double rightBackSpeed, double rightFrontSpeed){
        motors.setRunMode(Motor.RunMode.RawPower);

        leftBack.setInverted(true);
        leftFront.setInverted(true);

        telemetry.addData("left back (DriveSubsystem)", leftBackSpeed);
        telemetry.addData("left front (DriveSubsystem)", leftFrontSpeed);
        telemetry.addData("right back (DriveSubsystem)", rightBackSpeed);
        telemetry.addData("right front (DriveSubsystem)", rightFrontSpeed);

        leftBack.set(leftBackSpeed * .444);
        leftFront.set(leftFrontSpeed * .444);
        rightBack.set(rightBackSpeed * .444);
        rightFront.set(rightFrontSpeed * .444);
    }

    public void initializeIMU(IMU.Parameters parameters){
        imu.initialize(parameters);
    }
}

