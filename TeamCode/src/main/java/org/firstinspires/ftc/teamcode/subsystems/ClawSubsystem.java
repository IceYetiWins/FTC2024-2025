package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.ServoEx;

public class ClawSubsystem extends SubsystemBase {
    private final ServoEx servo;

    public ClawSubsystem(ServoEx servo){
        this.servo = servo;
        //servo.setInverted(true); //if needed
    }

    public void toAngle(double degrees){
        servo.turnToAngle(degrees);
    }
}
