package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.ClawSubsystem;

import java.util.function.BooleanSupplier;

public class ClawCommand extends CommandBase {
    private final ClawSubsystem clawSubsystem;
    private final BooleanSupplier close;
    private final double openDegrees1, closedDegrees1, openDegrees2, closedDegrees2;

    public ClawCommand(ClawSubsystem subsystem, BooleanSupplier close, double openDegrees1, double closedDegrees1, double openDegrees2, double closedDegrees2){
        clawSubsystem = subsystem;

        this.close = close;
        this.openDegrees1 = openDegrees1;
        this.openDegrees2 = openDegrees2;
        this.closedDegrees1 = closedDegrees1;
        this.closedDegrees2 = closedDegrees2;
        addRequirements(subsystem);
    }

    @Override
    public void execute(){
        if (close.getAsBoolean()){
            clawSubsystem.toAngle(closedDegrees1, closedDegrees2);
        } else {
            clawSubsystem.toAngle(openDegrees1, openDegrees2);
        }
    }
}
