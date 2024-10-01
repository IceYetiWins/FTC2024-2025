package org.firstinspires.ftc.teamcode.opmodes;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.commands.TestCommand;
import org.firstinspires.ftc.teamcode.subsystems.TestSubsystem;

@TeleOp
public class TestOpMode extends CommandOpMode {

    @Override
    public void initialize() {
        GamepadEx gamepad = new GamepadEx(gamepad1);

        double speed = gamepad.getLeftY();

        TestSubsystem testSubsystem = new TestSubsystem(hardwareMap, "motor0", Motor.GoBILDA.RPM_312, "servo0");
        TestCommand testCommand = new TestCommand(testSubsystem, speed);
        CommandScheduler.getInstance().setDefaultCommand(testSubsystem, testCommand);
    }
}
