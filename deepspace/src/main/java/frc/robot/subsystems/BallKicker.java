/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class BallKicker extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  
  private DoubleSolenoid ballKicker=new DoubleSolenoid(2, 3);//need to confirm ports

  
  @Override
  public void initDefaultCommand() {
    retract();
  }
  public void extend() {
    ballKicker.set(DoubleSolenoid.Value.kReverse);
 }

 public void retract() {
   ballKicker.set(DoubleSolenoid.Value.kForward);
 }
}
