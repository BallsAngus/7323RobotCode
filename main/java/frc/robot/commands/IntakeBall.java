package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class IntakeBall extends CommandBase
{
    public IntakeBall()
    {
        // add intake requirement to command constructor
        addRequirements(Robot.intake);
    }

    @Override
    public void initialize()
    {
        // reset the motor speeds
        Robot.intake.reset();
    }

    @Override
    public void execute()
    {
        // spin the intake while a button is pressed
        boolean isPressed = Robot.container.getRawButton(3); // initialize button
        Robot.intake.getBall(isPressed); // activate launcher when the button is pressed
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}