package org.firstinspires.ftc.teamcode.opmodes;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.teamcode.commands.ArmRotateCommand;
import org.firstinspires.ftc.teamcode.commands.ClawCommand;
import org.firstinspires.ftc.teamcode.commands.DriveTeleOpCommand;
import org.firstinspires.ftc.teamcode.commands.SlidesCommand;
import org.firstinspires.ftc.teamcode.subsystems.ArmRotateSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.ClawSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.SlidesSubsystem;

@TeleOp
public class StandardTeleOp extends CommandOpMode {

    private static final Motor.GoBILDA DRIVE_RPM = Motor.GoBILDA.RPM_435;
    private static final Motor.GoBILDA ARM_EXTEND_RPM = Motor.GoBILDA.RPM_312; //change if needed
    private static final Motor.GoBILDA ARM_ROTATE_RPM = Motor.GoBILDA.RPM_312;

    private static final double ARM_EXTEND_SPEED = .1;
    private static final double CLAW_MIN_DEGREES = 0, CLAW_MAX_DEGREES = 360;
    private static final double ARM_ROTATE_SPEED = .25;

    @Override
    public void initialize(){
        GamepadEx gamepad = new GamepadEx(gamepad1);

        DriveSubsystem drive = new DriveSubsystem(new MotorEx(hardwareMap, "leftBack", DRIVE_RPM),
                new MotorEx(hardwareMap, "leftFront", DRIVE_RPM),
                new MotorEx(hardwareMap, "rightBack", DRIVE_RPM),
                new MotorEx(hardwareMap, "rightFront", DRIVE_RPM),
                hardwareMap.get(IMU.class, "imu"),
                telemetry);

        SlidesSubsystem slides = new SlidesSubsystem(new MotorEx(hardwareMap, "extend1", ARM_EXTEND_RPM), new MotorEx(hardwareMap, "extend2", ARM_EXTEND_RPM));

        ArmRotateSubsystem armRotate = new ArmRotateSubsystem(new MotorEx(hardwareMap, "rotateMotor1", ARM_ROTATE_RPM), new MotorEx(hardwareMap, "rotateMotor2", ARM_ROTATE_RPM));

        ClawSubsystem claw = new ClawSubsystem(new SimpleServo(hardwareMap, "claw1", CLAW_MIN_DEGREES, CLAW_MAX_DEGREES), new SimpleServo(hardwareMap, "claw2", CLAW_MIN_DEGREES, CLAW_MAX_DEGREES));

        drive.setDefaultCommand(new DriveTeleOpCommand(drive,
                hardwareMap.get(IMU.class, "imu"),
                new IMU.Parameters(new RevHubOrientationOnRobot(RevHubOrientationOnRobot.LogoFacingDirection.UP, RevHubOrientationOnRobot.UsbFacingDirection.FORWARD)),
                gamepad::getLeftY, gamepad::getLeftX, gamepad::getRightX, () -> gamepad.getButton(GamepadKeys.Button.BACK), telemetry));

        slides.setDefaultCommand(new SlidesCommand(slides, () -> gamepad.getButton(GamepadKeys.Button.A), () -> gamepad.getButton(GamepadKeys.Button.B), ARM_EXTEND_SPEED));

        armRotate.setDefaultCommand(new ArmRotateCommand(armRotate, () -> gamepad.getButton(GamepadKeys.Button.A), () -> gamepad.getButton(GamepadKeys.Button.B), ARM_ROTATE_SPEED));

        claw.setDefaultCommand(new ClawCommand(claw, () -> gamepad.getButton(GamepadKeys.Button.RIGHT_BUMPER), 60, 120, 60, 120));
    }
}
