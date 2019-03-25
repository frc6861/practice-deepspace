package frc.robot.auton;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.OI;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.commands.Drive;
import frc.robot.subsystems.DriveTrain;
import java.nio.ByteBuffer;
import edu.wpi.first.wpilibj.I2C;
    public class ColorSensor{
        public I2C sensor;
        ByteBuffer buffer = ByteBuffer.allocate(1);
		public int white;
        public ColorSensor(){
            I2C sensor = new I2C(I2C.Port.kOnboard, 0x39); // 0x39 is the sensor's i2c address
            sensor.write(0x00, 192); //0b11000000 ... Power on, color sensor on. (page 20 of sensor datasheet)
        }
        public int white(){
        sensor.read(0x09, 1, buffer);// Hexadecimal code for white
            return buffer.get(0);
        }
    }