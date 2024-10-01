package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class TestSubsystem extends SubsystemBase{
    private final Motor motor;
    private final SimpleServo servo;

    public TestSubsystem(final HardwareMap hMap, final String motorName, final Motor.GoBILDA motorRPM, final String servoName){
        motor = new Motor(hMap, motorName, motorRPM);
        servo = new SimpleServo(hMap, servoName, 0, 300);
    }

    public void halfSpeed(){
        motor.set(.5);
    }

    public void halfSpin() {
        servo.setPosition(.5);
    }

    public void fullSpin() {
        servo.setPosition(1);
    }

    public void setMotor(double speed) {
        motor.set(speed * 100);
    }

}
