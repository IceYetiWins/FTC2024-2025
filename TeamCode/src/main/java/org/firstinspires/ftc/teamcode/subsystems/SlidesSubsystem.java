package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;

public class SlidesSubsystem extends SubsystemBase {
    private final MotorEx motor1, motor2;

    public SlidesSubsystem(MotorEx motor1, MotorEx motor2){
        this.motor1 = motor1;
        this.motor1.setRunMode(Motor.RunMode.RawPower);
        this.motor1.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        this.motor2 = motor2;
        this.motor2.setRunMode(Motor.RunMode.RawPower);
        this.motor2.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
    }

    public void extend(boolean extend, double speed){
        if (extend) {
            motor2.set(speed);
        } else if (speed == 0){
            motor2.set(0);
        } else {
            motor2.set(-speed);
        }
    }
}
