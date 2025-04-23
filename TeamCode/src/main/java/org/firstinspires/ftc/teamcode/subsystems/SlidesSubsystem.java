package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;

public class SlidesSubsystem extends SubsystemBase {
    private final MotorEx extendMotor;

    public SlidesSubsystem(MotorEx extendMotor){
        this.extendMotor = extendMotor;
        this.extendMotor.setRunMode(Motor.RunMode.RawPower);
        this.extendMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
    }

    public void extend(boolean extend, double speed){
        if (extend) {
            extendMotor.set(speed);
        } else if (speed == 0){
            extendMotor.set(0);
        } else {
            extendMotor.set(-speed);
        }
    }
}
