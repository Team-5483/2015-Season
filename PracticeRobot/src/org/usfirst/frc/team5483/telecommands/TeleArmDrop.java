package org.usfirst.frc.team5483.telecommands;

import org.usfirst.frc.team5483.io.RobotOutput;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class TeleArmDrop implements TeleopComponent{
	

	private static TeleArmDrop instance;
	RobotOutput robotOut = RobotOutput.getInstance();
	

	
	private TeleArmDrop(){
		this.robotOut = RobotOutput.getInstance();
		
		//add controllerOutput and other initializing stuff here
	}
	
	public void doWork(){
		if(this.robotOut.stick.getRawButton(5) && this.robotOut.getDrop() == false ){
			this.robotOut.dropSolenoid1.set(true);
			this.robotOut.dropSolenoid2.set(false);
			this.robotOut.setDrop(true);
			SmartDashboard.putBoolean("Drop value", this.robotOut.getDrop());
		}
		if(this.robotOut.stick.getRawButton(6) && this.robotOut.getDrop() == true ){
			this.robotOut.dropSolenoid1.set(false);
			this.robotOut.dropSolenoid2.set(true);
			this.robotOut.setDrop(false);
			SmartDashboard.putBoolean("Drop value", this.robotOut.getDrop());
		}
	}
	
	public void shutDown(){
		this.robotOut.dropSolenoid1.set(false);
		this.robotOut.dropSolenoid2.set(false);
	}
	
	public static TeleArmDrop getInstance() {
		if (TeleArmDrop.instance == null){
			TeleArmDrop.instance = new TeleArmDrop();
		}
		return TeleArmDrop.instance; 
	}
}
	