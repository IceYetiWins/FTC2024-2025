package org.firstinspires.ftc.teamcode.opmodes;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.teamcode.commands.DriveTeleOpCommand;
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;

@TeleOp
public class StandardTeleOp extends CommandOpMode {

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

        drive.setDefaultCommand(new DriveTeleOpCommand(drive,
                hardwareMap.get(IMU.class, "imu"),
                new IMU.Parameters(new RevHubOrientationOnRobot(RevHubOrientationOnRobot.LogoFacingDirection.UP, RevHubOrientationOnRobot.UsbFacingDirection.FORWARD)),
                Motor.RunMode.VelocityControl,
                gamepad::getLeftY, gamepad::getLeftX, gamepad::getRightX, () -> gamepad.getButton(GamepadKeys.Button.BACK), telemetry));
    }
}
