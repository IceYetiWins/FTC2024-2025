package org.firstinspires.ftc.teamcode.commands;
import com.arcrobotics.ftclib.command.CommandBase;
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;
import java.util.function.BooleanSupplier;

public class DriveMotorTestCommand extends CommandBase {
    private final DriveSubsystem driveSubsystem;
    private final BooleanSupplier aButton, bButton, xButton, yButton, leftStick, leftBumper, rightStick, rightBumper;


    public DriveMotorTestCommand(DriveSubsystem subsystem, BooleanSupplier aButton, BooleanSupplier bButton, BooleanSupplier xButton, BooleanSupplier yButton, BooleanSupplier leftStick, BooleanSupplier leftBumper, BooleanSupplier rightStick, BooleanSupplier rightBumper){
        driveSubsystem = subsystem;
        this.aButton = aButton;
        this.bButton = bButton;
        this.xButton = xButton;
        this.yButton = yButton;
        this.leftStick = leftStick;
        this.leftBumper = leftBumper;
        this.rightStick = rightStick;
        this.rightBumper = rightBumper;
        addRequirements(subsystem);
    }

    @Override
    public void execute(){
        double leftBackSpeed;
        if (leftStick.getAsBoolean()) {
            leftBackSpeed = -1;
        } else if (aButton.getAsBoolean()) {
            leftBackSpeed = 1;
        } else {
            leftBackSpeed = 0;
        }

        double leftFrontSpeed;
        if (leftBumper.getAsBoolean()) {
            leftFrontSpeed = -1;
        } else if (bButton.getAsBoolean()) {
            leftFrontSpeed = 1;
        } else {
            leftFrontSpeed = 0;
        }

        double rightBackSpeed;
        if (rightStick.getAsBoolean()) {
            rightBackSpeed = -1;
        } else if (xButton.getAsBoolean()) {
            rightBackSpeed = 1;
        } else {
            rightBackSpeed = 0;
        }

        double rightFrontSpeed;
        if (rightBumper.getAsBoolean()) {
            rightFrontSpeed = -1;
        } else if (yButton.getAsBoolean()) {
            rightFrontSpeed = 1;
        } else {
            rightFrontSpeed = 0;
        }

        driveSubsystem.setMotors(leftBackSpeed, leftFrontSpeed, rightBackSpeed, rightFrontSpeed);
    }
}