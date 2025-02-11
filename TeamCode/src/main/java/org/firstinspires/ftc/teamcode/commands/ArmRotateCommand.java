package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.ArmRotateSubsystem;

import java.util.function.BooleanSupplier;

public class ArmRotateCommand extends CommandBase {
    private final ArmRotateSubsystem armRotateSubsystem;
    private final BooleanSupplier raiseArm, lowerArm;
    private final double speed;

    public ArmRotateCommand(ArmRotateSubsystem subsystem, BooleanSupplier raiseArm, BooleanSupplier lowerArm, double speed) {
        armRotateSubsystem = subsystem;

        this.raiseArm = raiseArm;
        this.lowerArm = lowerArm;
        this.speed = speed;

        addRequirements(subsystem);
    }

    @Override
    public void execute() {
        if (raiseArm.getAsBoolean()){
            armRotateSubsystem.setPower(speed);
        } else if (lowerArm.getAsBoolean()){
            armRotateSubsystem.setPower(-speed);
        } else {
            armRotateSubsystem.setPower(0);
        }
    }
}
