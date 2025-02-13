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
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.MecanumDrive;

@Autonomous(preselectTeleOp = "StandardTeleOp")
@Config
public class AscentAuto extends LinearOpMode {
    public class ArmRotate {
        private MotorEx rotateMotor;

        public ArmRotate(HardwareMap hardwareMap){
            rotateMotor = new MotorEx(hardwareMap, "rotateMotor", Motor.GoBILDA.RPM_30); //change if needed
            rotateMotor.setRunMode(Motor.RunMode.RawPower);
            rotateMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        }

        public class ArmRotateUp implements Action {
            private boolean initialized = false;

            @Override
            public boolean run(@NonNull TelemetryPacket packet) {
                if (!initialized){
                    rotateMotor.set(1); //change this
                    initialized = true;
                }

                double pos = rotateMotor.getCurrentPosition();
                packet.put("armRotatePos", pos);

                if (pos < 3000.0) { //change the 3000
                    return true;
                } else {
                    rotateMotor.set(0);
                    return false;
                }
            }
        }

        public Action armRotateUp(){
            return new ArmRotateUp();
        }

        public class ArmRotateDown implements Action {
            private boolean initialized = false;

            @Override
            public boolean run(@NonNull TelemetryPacket packet) {
                if (!initialized){
                    rotateMotor.set(-1); //change this
                    initialized = true;
                }

                double pos = rotateMotor.getCurrentPosition();
                packet.put("armRotatePos", pos);

                if (pos > 500) { //change the 500
                    return true;
                } else {
                    rotateMotor.set(0);
                    return false;
                }
            }
        }

        public Action armRotateDown(){
            return new ArmRotateDown();
        }
    }

    public class Slides {
        private MotorEx motor1, motor2;

        public Slides(HardwareMap hardwareMap){
            motor1 = new MotorEx(hardwareMap, "extend1", Motor.GoBILDA.RPM_312); //change if needed
            motor1.setRunMode(Motor.RunMode.RawPower);
            motor1.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
            motor2 = new MotorEx(hardwareMap, "extend2", Motor.GoBILDA.RPM_312); //change if needed
            motor2.setRunMode(Motor.RunMode.RawPower);
            motor2.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        }

        public class SlidesExtend implements Action {
            private boolean initialized = false;

            @Override
            public boolean run(@NonNull TelemetryPacket packet) {
                if (!initialized){
                    motor1.set(1); //change this
                    motor1.set(-1); //change this
                    initialized = true;
                }

                double pos = motor1.getCurrentPosition();
                packet.put("armExtendPos", pos);

                if (pos < 3000) { //change the 3000
                    return true;
                } else {
                    motor1.set(0);
                    motor2.set(0);
                    return false;
                }
            }
        }

        public Action slidesExtend(){
            return new SlidesExtend();
        }
    }

    @Override
    public void runOpMode() {
        Pose2d initialPose = new Pose2d(-20, -72, Math.PI/2); //need to add correct starting position (in inches?)
        MecanumDrive drive = new MecanumDrive(hardwareMap, initialPose);
        ArmRotate armRotate = new ArmRotate(hardwareMap);
        Slides slides = new Slides(hardwareMap);

        TrajectoryActionBuilder ascend = drive.actionBuilder(initialPose)
                .waitSeconds(1)
                .splineTo(new Vector2d(-20, 0), 0); //change position (in inches?)

        Actions.runBlocking(new SequentialAction(
                ascend.build(),
                armRotate.armRotateUp(),
                slides.slidesExtend(),
                armRotate.armRotateDown()
        ));
    }
}
