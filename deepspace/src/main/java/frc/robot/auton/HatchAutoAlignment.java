/*                                                                         *
*This program is meant to automatically align the robot with the white line*
*when the robot is equipped with a hatch. This program will allow the robot*
*to strafe until it aligns with a white line. Then, it drives forward to   *
*place the hatch on the cargo or the rocket.                               *
*                                                                         */
package frc.robot.auton;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.OI;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.Drive;
import frc.robot.subsystems.DriveTrain;
import java.nio.ByteBuffer;
import edu.wpi.first.wpilibj.I2C;
import frc.robot.auton.ColorSensor;

public class HatchAutoAlignment extends CommandGroup {
    private WPI_TalonSRX leftFront;
    private WPI_TalonSRX rightFront;
    private WPI_TalonSRX leftRear;
    private WPI_TalonSRX rightRear;
    private MecanumDrive mecanumDrive;
    public DriveTrain driveTrain;
    private OI oi;
    public I2C sensor;
    public ColorSensor colorSensor;

    public HatchAutoAlignment(OI m_oi, DriveTrain driveTrain) {
        this.oi = m_oi;
        this.driveTrain = driveTrain;
        requires(driveTrain);
    }

    @Override
    protected void initialize() {
      SmartDashboard.putString("Initializing Automatic Alignment","Starting...");
    }

    @Override
  protected void execute() {

    int sensewhite = colorSensor.white();

    if (sensewhite > 0)
    {
    driveTrain.setMecanumDriveCommand(0,0,0.25,0);

    while (sensewhite > 0) 
    {
        driveTrain.setMecanumDriveCommand(0,0,0.5,0);
        driveTrain.setMecanumDriveCommand(0,0,-0.5,0);
    }
  }

    if (sensewhite <= 0)
    {
    driveTrain.setMecanumDriveCommand(0.6, 0, 0, 0);
    SmartDashboard.putString("Driving!!!","Moving forward!!!");
    }
  }
}