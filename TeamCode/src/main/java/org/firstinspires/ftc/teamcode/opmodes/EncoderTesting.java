package org.firstinspires.ftc.teamcode.opmodes;

import com.acmerobotics.roadrunner.ftc.Encoder;
import com.acmerobotics.roadrunner.ftc.OverflowEncoder;
import com.acmerobotics.roadrunner.ftc.RawEncoder;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@TeleOp
public class EncoderTesting extends OpMode {
    public Encoder par0, par1, perp;

    @Override
    public void init(){
        par0 = new OverflowEncoder(new RawEncoder(hardwareMap.get(DcMotorEx.class, "leftBack")));
        par1 = new OverflowEncoder(new RawEncoder(hardwareMap.get(DcMotorEx.class, "rightFront")));
        perp = new OverflowEncoder(new RawEncoder(hardwareMap.get(DcMotorEx.class, "leftFront")));
    }

    @Override
    public void loop(){
        telemetry.addData("par0:", par0.getPositionAndVelocity().velocity);
        telemetry.addData("par1:", par1.getPositionAndVelocity().velocity);
        telemetry.addData("perp:", perp.getPositionAndVelocity().velocity);
    }
}
