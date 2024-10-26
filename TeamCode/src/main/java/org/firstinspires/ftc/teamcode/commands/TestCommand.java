package org.firstinspires.ftc.teamcode.commands;

//everything not in this class that we need to access
import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.TestSubsystem;

import java.util.function.DoubleSupplier;

public class TestCommand extends CommandBase { //commands are where specific things that subsystem(s) will do are defined, there can be many commands for one subsystem and many subsystems in one command
    private final TestSubsystem testSubsystem;
    private final DoubleSupplier motorSpeed;

    public TestCommand(TestSubsystem subsystem, DoubleSupplier speed){ //parameters needed are the subsystem and speed of the motor
        testSubsystem = subsystem; //makes the testsubsystem variable be the one in the method parameters
        motorSpeed = speed; //makes speed variable be gamepad stick value
        addRequirements(subsystem); //declares subsystem as a dependency for the command
    }

    @Override
    public void execute(){ //what the command does
        //runs these methods from testsubsystem
        testSubsystem.halfSpin();
        testSubsystem.fullSpin();
        testSubsystem.setMotor(motorSpeed.getAsDouble()); //this one takes in the speed we got from the gamepad
    }
}