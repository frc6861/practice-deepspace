package frc.robot.commands;

import frc.robot.commands.RunClimbMotor;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ClimbSequence extends CommandGroup {
    	public ClimbSequence(double RCMtimeout, double RFMtimeout) {
        //addSequential(new RunFrontMotors(RFMtimeout, -0.25));
        addSequential(new RunClimbMotor(RCMtimeout,0.25));
        addSequential(new ExtendClimbSol(0.25));
        addSequential(new RunFrontMotors(RFMtimeout, 0.25));
        addSequential(new RetractClimbSol(0.25));

    }
}