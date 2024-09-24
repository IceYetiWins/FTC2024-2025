package org.firstinspires.ftc.teamcode.opmodes;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.commands.TestCommand;
import org.firstinspires.ftc.teamcode.subsystems.TestSubsystem;

@TeleOp
public class TestOpMode extends CommandOpMode {

    @Override
    public void initialize() {
        TestSubsystem testSubsystem = new TestSubsystem(hardwareMap, "motor0");
        TestCommand testCommand = new TestCommand(testSubsystem);
        CommandScheduler.getInstance().setDefaultCommand(testSubsystem, testCommand);
    }
}
