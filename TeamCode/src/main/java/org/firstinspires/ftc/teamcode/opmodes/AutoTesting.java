package org.firstinspires.ftc.teamcode.opmodes;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import org.firstinspires.ftc.teamcode.MecanumDrive;

@Config
@Autonomous(name = "Auto_Testing", group = "Autonomous")
public class AutoTesting extends LinearOpMode {
    @Override
    public void runOpMode(){
        Pose2d initialPose = new Pose2d(56.5, 8.25, Math.PI/2); //need to add correct pose
        MecanumDrive drive = new MecanumDrive(hardwareMap, initialPose);

        //should move diagonal right while turning to face right, then move backwards, then go back to starting spot
        TrajectoryActionBuilder exampleTab = drive.actionBuilder(initialPose)
                .splineTo(new Vector2d(48, 48), 0)
                .waitSeconds(2)
                .lineToX(0)
                .waitSeconds(3)
                .setTangent(5 * Math.PI/2)
                .splineTo(new Vector2d(0, 0), Math.PI/2);

        TrajectoryActionBuilder tab = drive.actionBuilder(initialPose)
                .splineToConstantHeading(new Vector2d(22, 24), Math.PI / 2)
                //grab first piece
                .splineTo(new Vector2d(22, 24), 5 * Math.PI / 2); //rotate to 5pi/2
                //drop off piece

        Actions.runBlocking(new SequentialAction(tab.build())); //runs trajectory as action
    }
}
