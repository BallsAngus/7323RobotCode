package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * Class will be used for buttons and inputs for subsystems
 */
public class RobotContainer
{
    // controller variables
    public Joystick stick;
    public double modifier;

    // initialize the joystick
    public RobotContainer()
    {
        stick = new Joystick(0);
        modifier = stick.getRawAxis(3); // set the modifier value to the value of the joysticks slider
        //configureButtonBindings();
    }

    // method to control the speed modifier
    public double incrementMod()
    {
        modifier++;
        modifier /= 2;
        return modifier;
    }

    // return the x value of the joystick (left/right)
    public double getStickX()
    {
        return stick.getX();
    }

    // return the y value of the joystick (forward)
    public double getStickY()
    {
        return stick.getY();
    }

    // return the state of the button pressed (is it pressed or not)
    public boolean getRawButton(int button)
    {
        return stick.getRawButton(button);
    }

    //method to map buttons
    //WIP, write if using Xbox controller
    /* private void configureButtonBindings()
    {
        
    } */

}