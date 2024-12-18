package org.firstinspires.ftc.teamcode.commands;
import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;
import java.util.function.BooleanSupplier;

public class DriveMotorTestCommand extends CommandBase {
    private final DriveSubsystem driveSubsystem;
    private final Motor.RunMode runMode;
    private final BooleanSupplier aButton, bButton, xButton, yButton;


    public DriveMotorTestCommand(DriveSubsystem subsystem, Motor.RunMode runMode, BooleanSupplier aButton, BooleanSupplier bButton, BooleanSupplier xButton, BooleanSupplier yButton){
        driveSubsystem = subsystem;
        this.runMode = runMode;
        this.aButton = aButton;
        this.bButton = bButton;
        this.xButton = xButton;
        this.yButton = yButton;
        addRequirements(subsystem);
    }

    @Override
    public void execute(){
        double leftBackSpeed = aButton.getAsBoolean() ? 10000 : 0;
        double leftFrontSpeed = bButton.getAsBoolean() ? 10000 : 0;
        double rightBackSpeed = xButton.getAsBoolean() ? 10000 : 0;
        double rightFrontSpeed = yButton.getAsBoolean() ? 10000 : 0;

        driveSubsystem.setMotors(leftBackSpeed, leftFrontSpeed, rightBackSpeed, rightFrontSpeed, runMode);
    }
}