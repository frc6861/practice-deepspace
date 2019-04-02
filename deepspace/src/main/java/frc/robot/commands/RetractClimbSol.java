package frc.robot.commands;

import edu.wpi.first.wpilibj.command.TimedCommand;
import frc.robot.OI;
import frc.robot.subsystems.Climber;
import edu.wpi.first.wpilibj.Solenoid;

public class RetractClimbSol extends TimedCommand {
private Climber climber;
private Solenoid climbSolenoid;
private OI m_oi;
public RetractClimbSol(double timeout, Climber climber) {
super(timeout);
this.climber = climber;
}

// Called just before this Command runs the first time
@Override
protected void initialize() {
}

// Called repeatedly when this Command is scheduled to run
@Override
protected void execute() {
climbSolenoid.set(false);
}

// Make this return true when this Command no longer needs to run execute()
@Override
protected boolean isFinished() {
return false;
}

// Called once after isFinished returns true
@Override
protected void end() {
}

// Called when another command which requires one or more of the same
// subsystems is scheduled to run
@Override
protected void interrupted() {
}
}