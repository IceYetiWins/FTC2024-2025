package org.firstinspires.ftc.teamcode.opmodes;

//everything not in this class that we need to access
import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.commands.TestCommand;
import org.firstinspires.ftc.teamcode.subsystems.TestSubsystem;

@TeleOp //tells ftc app that it's teleop rather than autonomous
public class TestOpMode extends CommandOpMode { //opmodes are the thing we start on the control device, they take input and tell the commandscheduler which commands to run

    @Override
    public void initialize() { //runs only when the opmode starts
        GamepadEx gamepad = new GamepadEx(gamepad1); //adds the gamepad we're using as a gamepadex object

        double speed = gamepad.getLeftY(); //gets the y position of the left joystick

        TestSubsystem testSubsystem = new TestSubsystem(hardwareMap, "motor0", Motor.GoBILDA.RPM_312, "servo0"); //creates an instance of testsubsystem with motor0 and servo0 from the hardwaremap, and specifying the rpm of the motor
        TestCommand testCommand = new TestCommand(testSubsystem, speed); //creates an instance of testcommand, specifying which subsystem it is for and inputting the speed value we got from the gamepad
        CommandScheduler.getInstance().setDefaultCommand(testSubsystem, testCommand); //tells the commandscheduler the command that will run by default all the time is testcommand using the testsubsystem
    }
}
