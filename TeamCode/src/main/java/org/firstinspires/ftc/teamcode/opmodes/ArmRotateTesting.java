package org.firstinspires.ftc.teamcode.opmodes;

import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class ArmRotateTesting extends OpMode {
    private MotorEx rotateMotor;
    private static final double ROTATE_SPEED = .25;

    @Override
    public void init(){
        rotateMotor = new MotorEx(hardwareMap, "rotateMotor", Motor.GoBILDA.RPM_30);
        rotateMotor.setRunMode(Motor.RunMode.RawPower);
    }

    @Override
    public void loop(){
        if (gamepad1.a){
            rotateMotor.set(ROTATE_SPEED);
        } else if (gamepad1.b) {
            rotateMotor.set(-ROTATE_SPEED);
        } else {
            rotateMotor.set(0);
        }
    }
}