package org.usfirst.frc.team5483.telecommands;

import org.usfirst.frc.team5483.io.RobotOutput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TeleLift {
	
	private RobotOutput robotOut;
	private static TeleLift instance;
	
	
	public TeleLift(){
		this.robotOut = RobotOutput.getInstance();
		
		//add controllerOutput and other intializing stuff here
	}
	
	public void doWork(){
		if(this.robotOut.stick.getRawButton(1) && this.robotOut.getLift() == false && robotOut.getDrop() == true){
			this.robotOut.liftSolenoid1.set(true);
			this.robotOut.liftSolenoid2.set(false);
			this.robotOut.setLift(true);
			SmartDashboard.putBoolean("Lift value", this.robotOut.getLift());
		}else if(this.robotOut.stick.getRawButton(1) && this.robotOut.getLift() == true && this.robotOut.getDrop() == true){
			this.robotOut.liftSolenoid1.set(false);
			this.robotOut.liftSolenoid2.set(true);
			this.robotOut.setLift(false);
			SmartDashboard.putBoolean("Lift value", this.robotOut.getLift());
		}
	}
	
	public void shutDown(){
		this.robotOut.liftSolenoid1.set(false);
		this.robotOut.liftSolenoid2.set(false);
	}
	
	public static TeleLift getInstance() {
		if (TeleLift.instance == null){
			TeleLift.instance = new TeleLift();
		}
		return TeleLift.instance; 
	}
	
}
