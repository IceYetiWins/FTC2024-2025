package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.ServoEx;

public class ClawSubsystem extends SubsystemBase {
    private final ServoEx servo1, servo2;

    public ClawSubsystem(ServoEx servo1, ServoEx servo2){
        this.servo1 = servo1;
        servo1.setInverted(true);
        this.servo2 = servo2;
    }

    public void toAngle(double degrees1, double degrees2){
        servo1.turnToAngle(degrees1);
        servo2.turnToAngle(degrees2);
    }
}
