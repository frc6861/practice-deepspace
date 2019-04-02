/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.TimedCommand;
import frc.robot.subsystems.Climber;

public class RunClimbMotor extends TimedCommand {
    private double climberSpeed;
    private Climber climber;

    public RunClimbMotor(double RCMtimeout, Climber climber,double climberSpeed) {
        super(RCMtimeout);
        this.climber = climber;
        requires(climber);
        this.climberSpeed=climberSpeed;


    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        climber.climb(climberSpeed);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        climber.climb(climberSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        climber.climb(0);

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
