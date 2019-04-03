package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.TimedCommand;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.subsystems.BallKicker;
import frc.robot.subsystems.Climber;

public class ClimbPistonBack extends TimedCommand {
  private OI m_oi;
  
  public ClimbPistonBack(double timeout, OI m_oi) {
      super(timeout);
      this.m_oi = m_oi;
    // Use requires() here to declare subsystem dependencies
  
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    System.out.println("Extending...");
    Robot.climber.retractClimb();
   // Timer.delay(1.0);
    


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
