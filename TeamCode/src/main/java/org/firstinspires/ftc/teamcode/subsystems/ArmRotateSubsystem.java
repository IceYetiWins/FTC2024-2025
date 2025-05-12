package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;

public class ArmRotateSubsystem extends SubsystemBase {
    private final MotorEx rotateMotor1, rotateMotor2;

    public ArmRotateSubsystem(MotorEx rotateMotor1, MotorEx rotateMotor2) {
        this.rotateMotor1 = rotateMotor1;
        this.rotateMotor2 = rotateMotor2;
        this.rotateMotor1.setRunMode(Motor.RunMode.RawPower);
        this.rotateMotor1.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        this.rotateMotor2.setRunMode(Motor.RunMode.RawPower);
        this.rotateMotor2.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
    }

    public void setPower(double speed) {
        rotateMotor1.set(speed);
        rotateMotor2.set(speed);
    }
}