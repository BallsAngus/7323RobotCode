package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Launcher extends SubsystemBase
{
    // instance variables
    private CANSparkMax launch;
    private CANSparkMax slave;

    // launcher, initialize motor
    public Launcher(int initPort, int port2)
    {
        launch = new CANSparkMax(initPort, MotorType.kBrushed);
        slave = new CANSparkMax(port2, MotorType.kBrushed);
        slave.follow(launch);
    }

    // set the speed of the motor
    public void setLaunch(double speed)
    {
        launch.set(speed);
    }

    // trigger the motor when a button is pressed
    public void launch(boolean isPressed)
    {
        if(isPressed)
        {
            launch.set(-0.8);
            //slave.set(0.5);
        }
        else
        {
            launch.set(0.0);
            //slave.set(0.0);
        }
    }

    // getter for motor speed
    public double getSpeed()
    {
        return launch.get();
    }

    
}