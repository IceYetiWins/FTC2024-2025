//Line 2-6 imports code for the program
package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.TestSubsystem;

public class TestCommand extends CommandBase {
    private final TestSubsystem testSubsystem;
    private double speed;

    public TestCommand(TestSubsystem subsystem, double gamepadSpeed){
        testSubsystem = subsystem;
        addRequirements(subsystem);
        speed = gamepadSpeed;
    }

    @Override
    public void execute(){
        testSubsystem.halfSpin();
        testSubsystem.fullSpin();
        testSubsystem.setMotor(speed);
    }
}
