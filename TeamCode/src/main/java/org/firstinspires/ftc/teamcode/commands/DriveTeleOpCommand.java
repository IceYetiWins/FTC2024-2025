package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

public class DriveTeleOpCommand extends CommandBase {
    private final DriveSubsystem driveSubsystem;
    private final IMU imu;
    private final IMU.Parameters parameters;
    private final Motor.RunMode runMode;
    private final DoubleSupplier leftY, leftX, rightX;
    private final BooleanSupplier imuReset;
    private double leftBackSpeed, leftFrontSpeed, rightBackSpeed, rightFrontSpeed;
    private final Telemetry telemetry;


    public DriveTeleOpCommand(DriveSubsystem subsystem, IMU imu, IMU.Parameters parameters, Motor.RunMode runMode, DoubleSupplier leftY, DoubleSupplier leftX, DoubleSupplier rightX, BooleanSupplier imuReset, Telemetry telemetry){
        driveSubsystem = subsystem;
        this.imu = imu;
        this.parameters = parameters;
        this.runMode = runMode;
        this.leftY = leftY;
        this.leftX = leftX;
        this.rightX = rightX;
        this.imuReset = imuReset;
        this.telemetry = telemetry;
        addRequirements(subsystem);
    }

    public void calculateSpeed(Double leftY, Double leftX, Double rightX){
        double botHeading = imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);

        double rotX = leftX * Math.cos(-botHeading) - leftY * Math.sin(-botHeading);
        double rotY = leftX * Math.sin(-botHeading) + leftY * Math.cos(-botHeading);

        rotX = rotX * 1.1;

        double denominator = Math.max(Math.abs(rotY) + Math.abs(rotX) + Math.abs(rightX), 1);
        leftFrontSpeed = (rotY + rotX + rightX) / denominator;
        leftBackSpeed = (rotY - rotX + rightX) / denominator;
        rightFrontSpeed = (rotY - rotX - rightX) / denominator;
        rightBackSpeed = (rotY + rotX - rightX) / denominator;

        telemetry.addData("leftY", leftY);
        telemetry.addData("leftX", leftX);
        telemetry.addData("rightX", rightX);

        telemetry.addData("bot heading", botHeading);
        telemetry.addData("rotX", rotX);
        telemetry.addData("rotY", rotY);
        telemetry.addData("denominator", denominator);

        telemetry.addData("left back", leftBackSpeed);
        telemetry.addData("left front", leftFrontSpeed);
        telemetry.addData("right back", rightBackSpeed);
        telemetry.addData("right front", rightFrontSpeed);

        telemetry.update();
    }

    @Override
    public void initialize(){
        driveSubsystem.initializeIMU(parameters);
    }

    @Override
    public void execute(){
        calculateSpeed(leftY.getAsDouble(), leftX.getAsDouble(), rightX.getAsDouble());
        //reverse motor direction if necessary
        driveSubsystem.setMotors(leftBackSpeed, leftFrontSpeed, rightBackSpeed, rightFrontSpeed, runMode);
        if (imuReset.getAsBoolean()){
            imu.resetYaw();
        }
    }
}