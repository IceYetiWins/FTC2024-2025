package org.firstinspires.ftc.teamcode.subsystems;

//everything not in this class that we need to access
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class TestSubsystem extends SubsystemBase{ //subsystems are the base level, where base functions of the hardware are defined, only one command can be accessing a subsystem at a time
    private final Motor motor;
    private final SimpleServo servo;

    public TestSubsystem(final HardwareMap hMap, final String motorName, final Motor.GoBILDA motorRPM, final String servoName){ //everything this subsystem needs to access
        //initialize motor and servo based on method parameters
        motor = new Motor(hMap, motorName, motorRPM);
        servo = new SimpleServo(hMap, servoName, 0, 300);
    }

    //these methods can all be called from a command
    public void halfSpeed(){
        motor.set(.5);
    }

    public void halfSpin() {
        servo.setPosition(.5);
    }

    public void fullSpin() {
        servo.setPosition(1);
    }

    public void setMotor(double speed) { //speed initially from gamepad input, multiplied by 100 so it's obvious that it's spinning
        motor.set(speed * 100);
    }
}
