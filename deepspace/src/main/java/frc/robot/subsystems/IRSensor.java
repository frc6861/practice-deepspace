package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.subsystems.Ingestor;

public class IRSensor extends Subsystem {

    private DigitalInput ir = new DigitalInput(1);//FIGURE OUT THIS PORT AHHHHHHHHHHHHHHHHH-Ethan
    private double range;
    private Ingestor ingestor;
    
    @Override
    protected void initDefaultCommand() {
    if (!ir.get()){
        ingestor.driveMotors(0);
    }
    }
}