package org.usfirst.frc.team5483.io;
import edu.wpi.first.wpilibj.Gyro;

//credit to 1114
public class GDGyro extends Gyro{
	
	private double resetAdjustment;
    private double initialAngle;
    
    public GDGyro(int channel, double initAngle) {
        super(channel);
        this.resetAdjustment = 0.0;
        this.initialAngle = initAngle;
    }
    
    public GDGyro(int channel) {
        this(channel, 90.0);
    }
    
    public double getAngle() {
        return this.initialAngle - (super.getAngle() - this.resetAdjustment);
    }
    
    public double getAbsoluteAngle() {
        double value = this.getAngle() % 360;
        
        if(value >= 0.0) {
            return value;
        } else {
            return 360 + value;
        }
        
    }
    
    public void reset(double initAngle) {
        this.initialAngle = initAngle;
        this.resetAdjustment = super.getAngle();
    }
    
    public void reset() {
        this.reset(90);
    }
}
