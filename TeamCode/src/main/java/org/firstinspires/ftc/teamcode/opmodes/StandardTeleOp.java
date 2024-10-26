package org.firstinspires.ftc.teamcode.opmodes;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.teamcode.commands.DriveTeleOpCommand;
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;

@TeleOp
public class StandardTeleOp extends CommandOpMode {

    @Override
    public void initialize(){
        GamepadEx gamepad = new GamepadEx(gamepad1);

        DriveSubsystem drive = new DriveSubsystem(hardwareMap, "leftBack", "leftFront", "rightBack", "rightFront", Motor.GoBILDA.RPM_312, hardwareMap.get(IMU.class, "imu"));

        drive.setDefaultCommand(new DriveTeleOpCommand(drive, hardwareMap.get(IMU.class, "imu"), new IMU.Parameters(new RevHubOrientationOnRobot(RevHubOrientationOnRobot.LogoFacingDirection.UP, RevHubOrientationOnRobot.UsbFacingDirection.FORWARD)), Motor.RunMode.VelocityControl, gamepad::getLeftY, gamepad::getLeftX, gamepad::getRightX));
    }
}
