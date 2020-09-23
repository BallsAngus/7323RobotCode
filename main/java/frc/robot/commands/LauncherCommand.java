/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class LauncherCommand extends CommandBase {
  /**
   * Creates a new LauncherCommand.
   * Default command for launcher.
   * For Launcher subsystem. If trigger is pressed, launch the ball.
   */

  // Constructor, add requirements here.
  public LauncherCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.launcher);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Robot.launcher.setLaunch(0.0); // set the initial motor speeds to 0.
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    boolean isPressed = Robot.container.getRawButton(1); // initialize button
    Robot.launcher.launch(isPressed); // activate launcher when the button is pressed
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

  }

  // Returns true when the command should end.
  // Must return false for this command, otherwise it will just keep being rescheduled as opposed to ran.
  @Override
  public boolean isFinished() {
    return false;
  }
}
