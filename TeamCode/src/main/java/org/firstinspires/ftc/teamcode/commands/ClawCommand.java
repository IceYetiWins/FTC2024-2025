package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.ClawSubsystem;

import java.util.function.BooleanSupplier;

public class ClawCommand extends CommandBase {
    private final ClawSubsystem clawSubsystem;
    private final BooleanSupplier close;
    private final double openDegrees, closedDegrees;

    public ClawCommand(ClawSubsystem subsystem, BooleanSupplier close, double openDegrees, double closedDegrees){
        clawSubsystem = subsystem;

        this.close = close;
        this.openDegrees = openDegrees;
        this.closedDegrees = closedDegrees;

        addRequirements(subsystem);
    }

    @Override
    public void execute(){
        if (close.getAsBoolean()){
            clawSubsystem.toAngle(closedDegrees);
        } else {
            clawSubsystem.toAngle(openDegrees);
        }
    }
}
