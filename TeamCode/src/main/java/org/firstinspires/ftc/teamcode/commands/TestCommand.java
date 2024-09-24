package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.TestSubsystem;

public class TestCommand extends CommandBase {
    private final TestSubsystem testSubsystem;

    public TestCommand(TestSubsystem subsystem){
        testSubsystem = subsystem;
        addRequirements(subsystem);
    }

    @Override
    public void execute(){
        testSubsystem.halfSpeed();
    }
}
