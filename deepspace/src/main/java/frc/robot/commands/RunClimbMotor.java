/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.TimedCommand;
import frc.robot.Robot;
import frc.robot.subsystems.Climber;

public class RunClimbMotor extends TimedCommand {
    private double climberSpeed;
    private DigitalInput climbSwitch;
    private Climber climber;

    public RunClimbMotor(double RCMtimeout,double climberSpeed, Climber climber) {
        super(RCMtimeout);
        this.climber = climber;
        this.climberSpeed=climberSpeed;
        climbSwitch = Robot.climbLimitSwitch;

    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        while(climbSwitch.get()==false){
        climber.climb(climberSpeed);
        }
        while(climbSwitch.get()==true){
            climber.climb(climberSpeed);
        }
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
