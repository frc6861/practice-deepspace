/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.command.Command;

public class ArduinoCommand extends Command {

   // Open a new I2C connection on port 4
   I2C Wire = new I2C(Port.kOnboard, 4);
   private String action;
  public ArduinoCommand(String action) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    this.action=action;
    
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

    System.out.println("*************************ArduinoCommandinitialized");
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    System.out.println("*************************ArduinoCommandexecute");

        // The string message to be sent to the Arduino
      String WriteString =action;
      // Turn the string into a character array
      char[] CharArray = WriteString.toCharArray();
      // Make each character a single byte
      byte[] WriteData = new byte[CharArray.length];
      // For each item in the character array, add it as a single byte to the I2C connection
      for (int i = 0; i < CharArray.length; i++) {
        System.out.println("********************************* in loop "+i);
        WriteData[i] = (byte) CharArray[i];
      }
      // Send the data to the I2C connection
      System.out.println("*************************befor wire");
      System.out.println("Wire"+WriteData.length);
      //try {
        Wire.transaction(WriteData, WriteData.length, WriteData, 0);
     
      //} catch (Exception e) {
        //System.out.println(e.getMessage());
      //}


      System.out.println("*************************hello");

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
