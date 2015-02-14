package org.usfirst.frc.team5483.telecommands;

import org.usfirst.frc.team5483.io.RobotOutput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class TeleArmDrop {
	
	private static int armActivations = 0;
	private static TeleArmDrop instance;
	RobotOutput robotOut = RobotOutput.getInstance();
	

	
	public TeleArmDrop() {
		
		//robotOut.setExtend(false);
		
		
		if(this.robotOut.getX() == true){
			robotOut.dropSolenoid1.set(false);
			robotOut.dropSolenoid2.set(true);
			SmartDashboard.putString("ARM: ", "X is pressed.");
			//robotOut.setExtend(false);
		}else if (this.robotOut.){
			robotOut.armSolenoid1.set(true);
			robotOut.armSolenoid2.set(false);
		}
		
	}
	
	public static void activationsReset() {
		armActivations = 0;
	}
	
	public int getActivations() {
		return armActivations;
	}
	public static TeleArmDrop getInstance() {
		if (TeleArmDrop.instance == null){
			TeleArmDrop.instance = new TeleArmDrop();
		}
		return TeleArmDrop.instance; 
	}

}
