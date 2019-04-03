package frc.robot.commands;


import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class RunFrontMotors extends TimedCommand {
    private double speed;
    public RunFrontMotors(double RFMtimeout, double speed) {
    	 super (RFMtimeout);
        this.speed=speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
			Robot.driveTrain.setMecanumDriveCommand(0, speed, 0, 0); //used to be 0.5
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    // protected boolean isFinished() {
    //}
    

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}