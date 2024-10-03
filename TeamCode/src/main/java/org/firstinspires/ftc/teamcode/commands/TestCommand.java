package org.firstinspires.ftc.teamcode.commands;

//everything not in this class that we need to access
import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.gamepad.GamepadEx;

import org.firstinspires.ftc.teamcode.subsystems.TestSubsystem;

public class TestCommand extends CommandBase { //commands are where specific things that subsystem(s) will do are defined, there can be many commands for one subsystem and many subsystems in one command
    private final TestSubsystem testSubsystem;
    private double motorSpeed;

    public TestCommand(TestSubsystem subsystem, GamepadEx gamepad){ //parameters needed are the subsystem and speed of the motor
        testSubsystem = subsystem; //makes the testsubsystem variable be the one in the method parameters
        motorSpeed = Math.abs(gamepad.getLeftY()); //makes speed variable be gamepad value (from 0 to 1)
        addRequirements(subsystem); //declares subsystem as a dependency for the command
    }

    @Override
    public void execute(){ //what the command does
        //runs these methods from testsubsystem
        testSubsystem.halfSpin();
        testSubsystem.fullSpin();
        testSubsystem.setMotor(motorSpeed); //this one takes in the speed we got from the gamepad
    }
}
