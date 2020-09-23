package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase
{
    // declare motors
    private CANSparkMax rearLeft;
    private CANSparkMax rearRight;
    private CANSparkMax frontLeft;
    private CANSparkMax frontRight;
    private SpeedControllerGroup left;
    private SpeedControllerGroup right;
    private DifferentialDrive drive;
    
    // initialize motors
    public DriveTrain()
    {
        rearLeft = new CANSparkMax(1, MotorType.kBrushless);
        rearRight = new CANSparkMax(2, MotorType.kBrushless);
        frontLeft = new CANSparkMax(3, MotorType.kBrushless);
        frontRight = new CANSparkMax(4, MotorType.kBrushless); 
        left = new SpeedControllerGroup(frontLeft, rearLeft);
        right = new SpeedControllerGroup(frontRight, rearRight);
        drive = new DifferentialDrive(left, right);

    }
    // nice
    // basic drive method with one joystick, params are joystick directions, which are controlled by the RobotContainer class
    public void arcadeDrive(double speed, double rotation)
    {
        drive.arcadeDrive(speed, rotation);
    }

    public boolean isAuto(boolean isPressed)
    {
        if(isPressed)
        {
            return true;
        }
        return false;
    }

}