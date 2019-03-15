/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.auton;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.OI;
import frc.robot.commands.HatchUpTimed;
import frc.robot.subsystems.DriveTrain;

public class DeployHatchAuton extends CommandGroup {
  /**
   * Add your docs here.
   */
  public DeployHatchAuton(double time,DriveTrain driveTrain, OI m_oi) {
    // Add Commands here:
    addSequential(new CargoMiddleHatch(time, driveTrain));
    
    //addSequential(new HatchUpTimed(1.0, m_oi.getHatchPusher(),0.3));//double timeout, HatchPusher hatch, double speed
    //addSequential(new CargoMiddleHatch(0.3, driveTrain));
    // addSequential(new Command2());
    // these will run in order.

    // To run multiple commands at the same time,
    // use addParallel()
    // e.g. addParallel(new Command1());
    // addSequential(new Command2());
    // Command1 and Command2 will run in parallel.

    // A command group will require all of the subsystems that each member
    // would require.
    // e.g. if Command1 requires chassis, and Command2 requires arm,
    // a CommandGroup containing them would require both the chassis and the
    // arm.
  }
}
