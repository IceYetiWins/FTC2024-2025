package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.SlidesSubsystem;

import java.util.function.BooleanSupplier;

public class SlidesCommand extends CommandBase {
    private final SlidesSubsystem slidesSubsystem;
    private final BooleanSupplier extend, retract;
    private final double speed;

    public SlidesCommand(SlidesSubsystem subsystem, BooleanSupplier extend, BooleanSupplier retract, double speed){
        slidesSubsystem = subsystem;

        this.extend = extend;
        this.retract = retract;
        this.speed = speed;

        addRequirements(subsystem);
    }

    @Override
    public void execute(){
        if (extend.getAsBoolean()){
            slidesSubsystem.extend(true, speed);
        } else if (retract.getAsBoolean()){
            slidesSubsystem.extend(false, speed);
        } else {
            slidesSubsystem.extend(false, 0);
        }
    }
}
