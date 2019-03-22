/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.ElevatorPosition;
import frc.robot.subsystems.Elevator;

public class PositionElevator extends Command {
    private Elevator elevator;
    private double position;

    public PositionElevator(Elevator elevator, ElevatorPosition ballcargoship) {
        this.elevator = elevator;
        this.position = ballcargoship.getPosition();
        //elevator.setElevatiorHeight(position);
        // requires(driveTrain);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {

        System.out.println("position:"+position);
        System.out.println("calculated"+((position +15)-11)*206);
        System.out.println("actual"+ elevator.getElevatorHeight());
        elevator.setPower(0.3);

    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {

        boolean test=(Math.abs(-elevator.getElevatorHeight()-((position +15)-11)*206)<.0001);
        if(test)
        elevator.setPower(0);
       
        return (Math.abs(-elevator.getElevatorHeight()-((position +15)-11)*206)<.0001);
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
