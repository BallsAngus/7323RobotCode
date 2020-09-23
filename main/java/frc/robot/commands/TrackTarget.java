package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class TrackTarget extends CommandBase
{
    public TrackTarget()
    {
        addRequirements(Robot.drivetrain, Robot.limelight);
    }

    @Override
    public void initialize()
    {
        Robot.drivetrain.arcadeDrive(0.0, 0.0);
    }

    @Override
    public void execute()
    {
        Robot.limelight.Update_Limelight_Tracking();
        Robot.limelight.trackTarget();
    }

    @Override
    public boolean isFinished()
    {
        boolean isPressed = Robot.container.stick.getRawButton(2);
        if(!Robot.drivetrain.isAuto(isPressed))
            return true;
        return false;
    }


}