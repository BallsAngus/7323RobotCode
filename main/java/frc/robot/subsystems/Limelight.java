package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;

public class Limelight extends SubsystemBase
{
    private boolean m_LimelightHasValidTarget;
    private double m_LimelightDriveCommand;
    private double m_LimelightSteerCommand;

    public Limelight()
    {
        m_LimelightHasValidTarget = false;
        m_LimelightDriveCommand = 0.0;
        m_LimelightSteerCommand = 0.0;
    }

    public void Update_Limelight_Tracking()
    {
            // These numbers must be tuned for your Robot!  Be careful!
            final double STEER_K = 0.03;                    // how hard to turn toward the target
            final double DRIVE_K = 0.26;                    // how hard to drive fwd toward the target
            final double DESIRED_TARGET_AREA = 13.0;        // Area of the target when the robot reaches the wall
            final double MAX_DRIVE = 0.7;                   // Simple speed limit so we don't drive too fast

            double tv = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0);
            double tx = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
            double ty = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(0);
            double ta = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ta").getDouble(0);
            //SmartDashboard.putNumber("Tx", tx);
            //SmartDashboard.putNumber("Ta", ta);
            if (tv < 1.0)
            {
            m_LimelightHasValidTarget = false;
            m_LimelightDriveCommand = 0.0;
            m_LimelightSteerCommand = 0.0;
            return;
            }

            m_LimelightHasValidTarget = true;

            // Start with proportional steering
            double steer_cmd = tx * STEER_K;
            m_LimelightSteerCommand = steer_cmd;

            // try to drive forward until the target area reaches our desired area
            double drive_cmd = (DESIRED_TARGET_AREA - ta) * DRIVE_K;

            // don't let the robot drive too fast into the goal
            if (drive_cmd > MAX_DRIVE)
            {
            drive_cmd = MAX_DRIVE;
            }
            m_LimelightDriveCommand = drive_cmd;
    }

    
    public void trackTarget()
    {
        double steer = Robot.container.stick.getX();
        double drive = -Robot.container.stick.getY();
        boolean auto = Robot.container.stick.getRawButton(1);

        steer *= 0.70;
        drive *= 0.70;

        if (auto)
        {
          if (m_LimelightHasValidTarget)
          {
                Robot.drivetrain.arcadeDrive(m_LimelightDriveCommand,m_LimelightSteerCommand);
          }
          else
          {
                Robot.drivetrain.arcadeDrive(0.0,0.0);
          }
        }
        else
        {
          Robot.drivetrain.arcadeDrive(drive,steer);
        }
    }
}