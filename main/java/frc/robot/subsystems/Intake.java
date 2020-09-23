package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase
{
    private CANSparkMax intakeMotor;

    public Intake()
    {
        //initialize intakeMotor to port 5
        intakeMotor = new CANSparkMax(5, MotorType.kBrushed);
    }

    public void getBall(boolean isPressed)
    {
        //set the speed of the motor
        if(isPressed)
        {
            intakeMotor.set(0.6);
            //slave.set(0.5);
        }
        else
        {
            intakeMotor.set(0.0);
            //slave.set(0.0);
        }
    }

    public void reset()
    {
        intakeMotor.set(0.0);
    }
}