package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.subsystems.Ingestor;

public class ProximitySensor extends Subsystem {

    private Ultrasonic ultra = new Ultrasonic(1,1);
    private double range;
    private Ingestor ingestor;
    
    public ProximitySensor() {
        ultra.setAutomaticMode(true);
    }
    
    public void ultrasonicRange() {
        double range = ultra.getRangeMM();
    }

    @Override
    protected void initDefaultCommand() {
    if (range <= 3.5){
        ingestor.driveMotors(0);
    }
    }
}