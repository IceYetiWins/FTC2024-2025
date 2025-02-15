package org.firstinspires.ftc.teamcode.opmodes;

import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.teamcode.commands.DriveTeleOpCommand;
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;

@Autonomous(preselectTeleOp = "StandardTeleOp")
@Config
public class ParkAutoAlternate extends CommandOpMode {
    private static final Motor.GoBILDA DRIVE_RPM = Motor.GoBILDA.RPM_435;

    @Override
    public void initialize(){
        DriveSubsystem drive = new DriveSubsystem(new MotorEx(hardwareMap, "leftBack", DRIVE_RPM),
                new MotorEx(hardwareMap, "leftFront", DRIVE_RPM),
                new MotorEx(hardwareMap, "rightBack", DRIVE_RPM),
                new MotorEx(hardwareMap, "rightFront", DRIVE_RPM),
                hardwareMap.get(IMU.class, "imu"),
                telemetry);

//        drive.setDefaultCommand(new DriveTeleOpCommand(drive,
//                hardwareMap.get(IMU.class, "imu"),
//                new IMU.Parameters(new RevHubOrientationOnRobot(RevHubOrientationOnRobot.LogoFacingDirection.UP, RevHubOrientationOnRobot.UsbFacingDirection.FORWARD)),
//                () -> -.2, () -> .8, () -> .1, () -> false, telemetry));

        DriveTeleOpCommand command1 = new DriveTeleOpCommand(drive,
                hardwareMap.get(IMU.class, "imu"),
                new IMU.Parameters(new RevHubOrientationOnRobot(RevHubOrientationOnRobot.LogoFacingDirection.UP, RevHubOrientationOnRobot.UsbFacingDirection.FORWARD)),
                () -> -.2, () -> .8, () -> .1, () -> false, telemetry);

        DriveTeleOpCommand command2 = new DriveTeleOpCommand(drive,
                hardwareMap.get(IMU.class, "imu"),
                new IMU.Parameters(new RevHubOrientationOnRobot(RevHubOrientationOnRobot.LogoFacingDirection.UP, RevHubOrientationOnRobot.UsbFacingDirection.FORWARD)),
                () -> 0, () -> 0, () -> 0, () -> false, telemetry);

        CommandScheduler.getInstance().schedule(new SequentialCommandGroup(
                command1.withTimeout(3000), //change number of seconds
                command2
        ));
    }
}
