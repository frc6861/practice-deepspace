/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

//NOTE: THIS IS BASIC CODE FOR A CLIMBER, IF THIS GETS PUSHED CHECK WITH JACK BEFORE DELETING OTHERWISE ANGER WILL ENSURE ;)
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Solenoid;
/**
 * Add your docs here.
 */
public class Climber extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private WPI_TalonSRX climbMotor;
  private Solenoid climbSolenoid;

  public Climber() {
      climbMotor = new WPI_TalonSRX(14); 
      climbSolenoid = new Solenoid(4);
  }
  
  @Override
  public void initDefaultCommand() {
    climbMotor.set(0);
    retractClimb();
  }

  public void extendClimb(){
      climbSolenoid.set(true);
  }

  public void retractClimb(){
      climbSolenoid.set(false);
  }

  public void climb(double speed) {
    climbMotor.set(speed); 
  }
}
