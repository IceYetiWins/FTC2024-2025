package org.firstinspires.ftc.teamcode.opmodes;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.teamcode.commands.ArmRotateCommand;
import org.firstinspires.ftc.teamcode.commands.DriveTeleOpCommand;
import org.firstinspires.ftc.teamcode.subsystems.ArmRotateSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;

@TeleOp
public class StandardTeleOp extends CommandOpMode {

    private static final Motor.GoBILDA driveRPM = Motor.GoBILDA.RPM_435;
    private static final Motor.GoBILDA armRotateRPM = Motor.GoBILDA.RPM_30;

    private static final double armRotateSpeed = .25;

    @Override
    public void initialize(){
        GamepadEx gamepad = new GamepadEx(gamepad1);

        DriveSubsystem drive = new DriveSubsystem(new MotorEx(hardwareMap, "leftBack", driveRPM),
                new MotorEx(hardwareMap, "leftFront", driveRPM),
                new MotorEx(hardwareMap, "rightBack", driveRPM),
                new MotorEx(hardwareMap, "rightFront", driveRPM),
                hardwareMap.get(IMU.class, "imu"),
                telemetry);

        ArmRotateSubsystem armRotate = new ArmRotateSubsystem(new MotorEx(hardwareMap, "rotateMotor", armRotateRPM));

        drive.setDefaultCommand(new DriveTeleOpCommand(drive,
                hardwareMap.get(IMU.class, "imu"),
                new IMU.Parameters(new RevHubOrientationOnRobot(RevHubOrientationOnRobot.LogoFacingDirection.UP, RevHubOrientationOnRobot.UsbFacingDirection.FORWARD)),
                gamepad::getLeftY, gamepad::getLeftX, gamepad::getRightX, () -> gamepad.getButton(GamepadKeys.Button.BACK), telemetry));

        armRotate.setDefaultCommand(new ArmRotateCommand(armRotate, () -> gamepad.getButton(GamepadKeys.Button.A), () -> gamepad.getButton(GamepadKeys.Button.B), armRotateSpeed));
    }
}
