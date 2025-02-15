package org.firstinspires.ftc.teamcode.opmodes;

import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class ClawTesting extends OpMode {
    private ServoEx servo1, servo2;

    @Override
    public void init(){
        servo1 = new SimpleServo(hardwareMap, "claw1", 0, 360);
        servo1.setInverted(true);
        servo2 = new SimpleServo(hardwareMap, "claw2", 0, 360);
    }

    @Override
    public void loop(){
        if (gamepad1.a){
            servo1.turnToAngle(50);
            servo2.turnToAngle(50);
        } else {
            servo1.turnToAngle(120);
            servo2.turnToAngle(120);
        }
    }
}
