package org.usfirst.frc.team5483.auton.commands;

import org.usfirst.frc.team5483.auton.AutoComd;
import org.usfirst.frc.team5483.io.RobotOutput;

public class AutoLift extends AutoComd{
	RobotOutput robotOut;
	private boolean liftV = robotOut.getLift();
	
	public AutoLift(){
		super(AutoComd.CMD_LIFT);
		this.robotOut = RobotOutput.getInstance();
		
		// initialize auto stuff here for drop
	}
	
	
	public boolean calculate() {
		if(liftV == false){
			robotOut.dropSolenoid1.set(false);/*-----------TODO:might need to invert values depending on how it is connected-----------*/
			robotOut.dropSolenoid2.set(true);
			robotOut.setLift(true);
			return true;	
		}else{
			robotOut.dropSolenoid1.set(true);/*-----------TODO:might need to invert values depending on how it is connected-----------*/
			robotOut.dropSolenoid2.set(false);
			robotOut.setLift(false);
			return true;
		}
	}
}
