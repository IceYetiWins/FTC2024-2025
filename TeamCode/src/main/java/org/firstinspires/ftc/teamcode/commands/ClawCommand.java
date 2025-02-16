package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.ClawSubsystem;

import java.util.function.BooleanSupplier;

public class ClawCommand extends CommandBase {
    private final ClawSubsystem clawSubsystem;
    private final BooleanSupplier open;
    private final double closedDegrees1, openDegrees1, closedDegrees2, openDegrees2;

    public ClawCommand(ClawSubsystem subsystem, BooleanSupplier open, double closedDegrees1, double openDegrees1, double closedDegrees2, double openDegrees2){
        clawSubsystem = subsystem;

        this.open = open;
        this.closedDegrees1 = closedDegrees1;
        this.closedDegrees2 = closedDegrees2;
        this.openDegrees1 = openDegrees1;
        this.openDegrees2 = openDegrees2;
        addRequirements(subsystem);
    }

    @Override
    public void execute(){
        if (open.getAsBoolean()){
            clawSubsystem.toAngle(openDegrees1, openDegrees2);
        } else {
            clawSubsystem.toAngle(closedDegrees1, closedDegrees2);
        }
    }
}
