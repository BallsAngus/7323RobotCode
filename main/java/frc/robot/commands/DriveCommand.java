package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class DriveCommand extends CommandBase
{

    // Constructor, add requirements here.
     public DriveCommand() {
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(Robot.drivetrain);
     }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        Robot.drivetrain.arcadeDrive(0.0, 0.0);
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        Robot.drivetrain.arcadeDrive(Robot.container.stick.getY(), Robot.container.stick.getX());
    }


    // Returns true when the command should end.
    // Must return false for this command, otherwise it will just keep being rescheduled as opposed to ran.
    @Override
    public boolean isFinished() {
        return false;
    }

}