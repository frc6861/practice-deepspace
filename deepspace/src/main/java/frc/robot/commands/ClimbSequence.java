package frc.robot.commands;

import frc.robot.commands.RunClimbMotor;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ClimbSequence extends CommandGroup {
    private Climber climber;
    private DriveTrain driveTrain;
	public ClimbSequence(double RCMtimeout, double RFMtimeout) {
        addSequential(new RunClimbMotor(RCMtimeout, climber, 0.5));
        addSequential(new ExtendClimbSol(0.1, climber));
        addSequential(new RunFrontMotors(RFMtimeout, driveTrain, 0.5));
        addSequential(new RetractClimbSol(0.1, climber));

    }
}