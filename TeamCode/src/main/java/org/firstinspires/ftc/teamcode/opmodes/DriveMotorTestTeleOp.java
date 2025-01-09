package org.firstinspires.ftc.teamcode.opmodes;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.teamcode.commands.DriveMotorTestCommand;
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;

@TeleOp
public class DriveMotorTestTeleOp extends CommandOpMode {

    private static final Motor.GoBILDA motorRPM = Motor.GoBILDA.RPM_435;

    @Override
    public void initialize(){
        GamepadEx gamepad = new GamepadEx(gamepad1);

        DriveSubsystem drive = new DriveSubsystem(new MotorEx(hardwareMap, "leftBack", motorRPM),
                new MotorEx(hardwareMap, "leftFront", motorRPM),
                new MotorEx(hardwareMap, "rightBack", motorRPM),
                new MotorEx(hardwareMap, "rightFront", motorRPM),
                hardwareMap.get(IMU.class, "imu"),
                telemetry);

        drive.setDefaultCommand(new DriveMotorTestCommand(drive,
                () -> gamepad.getButton(GamepadKeys.Button.A),
                () -> gamepad.getButton(GamepadKeys.Button.B),
                () -> gamepad.getButton(GamepadKeys.Button.X),
                () -> gamepad.getButton(GamepadKeys.Button.Y),
                () -> gamepad.getButton(GamepadKeys.Button.LEFT_STICK_BUTTON),
                () -> gamepad.getButton(GamepadKeys.Button.LEFT_BUMPER),
                () -> gamepad.getButton(GamepadKeys.Button.RIGHT_STICK_BUTTON),
                () -> gamepad.getButton(GamepadKeys.Button.RIGHT_BUMPER)));
    }
}
