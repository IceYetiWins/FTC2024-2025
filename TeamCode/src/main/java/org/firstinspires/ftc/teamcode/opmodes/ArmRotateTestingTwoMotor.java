package org.firstinspires.ftc.teamcode.opmodes;

import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class ArmRotateTestingTwoMotor extends OpMode {
    private MotorEx rotateMotor1, rotateMotor2;
    private static final double ROTATE_SPEED = .5;

    @Override
    public void init(){
        rotateMotor1 = new MotorEx(hardwareMap, "rotateMotor1", Motor.GoBILDA.RPM_312);
        rotateMotor1.setRunMode(Motor.RunMode.RawPower);
        rotateMotor1.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        rotateMotor2 = new MotorEx(hardwareMap, "rotateMotor2", Motor.GoBILDA.RPM_312);
        rotateMotor2.setRunMode(Motor.RunMode.RawPower);
        rotateMotor2.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
    }

    @Override
    public void loop(){
        if (gamepad1.a){
            rotateMotor1.set(ROTATE_SPEED);
            rotateMotor2.set(-ROTATE_SPEED);
        } else if (gamepad1.b) {
            rotateMotor1.set(-ROTATE_SPEED);
            rotateMotor2.set(ROTATE_SPEED);
        } else {
            rotateMotor1.set(0);
            rotateMotor2.set(0);
        }
    }
}