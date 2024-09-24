package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class TestSubsystem extends SubsystemBase{
    private final Motor motor;

    public TestSubsystem(final HardwareMap hMap, final String name){
        motor = hMap.get(Motor.class, name);
    }

    public void halfSpeed(){
        motor.set(.5);
    }
}
