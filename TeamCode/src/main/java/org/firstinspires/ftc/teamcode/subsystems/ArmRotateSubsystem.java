package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;

public class ArmRotateSubsystem extends SubsystemBase {
    private final MotorEx rotateMotor;

    public ArmRotateSubsystem(MotorEx rotateMotor) {
        this.rotateMotor = rotateMotor;
        this.rotateMotor.setRunMode(Motor.RunMode.RawPower);
        this.rotateMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
    }

    public void setPower(double speed) {
        rotateMotor.set(speed);
    }
}
