package org.firstinspires.ftc.teamcode.opmodes;

import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class ArmExtendTesting extends OpMode {
    private MotorEx extend1, extend2;
    private static final double EXTEND_SPEED = .1;

    @Override
    public void init(){
        extend1 = new MotorEx(hardwareMap, "extend1", Motor.GoBILDA.RPM_312);
        extend2 = new MotorEx(hardwareMap, "extend2", Motor.GoBILDA.RPM_312);
        extend1.setRunMode(Motor.RunMode.RawPower);
        extend2.setRunMode(Motor.RunMode.RawPower);
    }

    @Override
    public void loop(){
        if (gamepad1.a){
            extend1.set(EXTEND_SPEED);
            extend2.set(-EXTEND_SPEED);
        } else if (gamepad1.b) {
            extend1.set(-EXTEND_SPEED);
            extend2.set(EXTEND_SPEED);
        } else {
            extend1.set(0);
            extend2.set(0);
        }
    }
}
