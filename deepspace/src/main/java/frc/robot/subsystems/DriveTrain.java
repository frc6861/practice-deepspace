/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.OI;
import frc.robot.commands.Drive;

public class DriveTrain extends Subsystem {
    private WPI_TalonSRX leftFront;
    private WPI_TalonSRX rightFront;
    private WPI_TalonSRX leftRear;
    private WPI_TalonSRX rightRear;
    private MecanumDrive mecanumDrive;
    private OI m_oi;

    public DriveTrain(OI m_oi) {

        leftFront = new WPI_TalonSRX(10);// 14 front left, 15 front right elevator 13
        rightFront = new WPI_TalonSRX(11);// 0 back left 1 back right
        leftRear = new WPI_TalonSRX(24); // PRACTICE ROBOT
        rightRear = new WPI_TalonSRX(25);

        this.m_oi = m_oi;
        mecanumDrive = new MecanumDrive(leftFront, leftRear, rightFront, rightRear);
    }

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new Drive(m_oi, this));
    }

    public void setMecanumDriveCommand(double ySpeed, double xSpeed, double zRotation, double gyroAngle) {
        if (m_oi.getRT1() > 0.1) {
            mecanumDrive.driveCartesian(0.4 * ySpeed, 0.4 * xSpeed, 0.4 * zRotation);
        } else if(m_oi.getLT1() > 0.1){
            mecanumDrive.driveCartesian(0.2 * ySpeed, 0.2 * xSpeed, 0.2 * zRotation);
        }
        else {
            mecanumDrive.driveCartesian(ySpeed, xSpeed, zRotation);
        }

    }

}
