package org.usfirst.frc.team5483.auton.commands;

import org.usfirst.frc.team5483.io.RobotOutput;

public class AutoDrop implements AutonComponent{
	RobotOutput robotOut;
	
	public AutoDrop(){
		robotOut = RobotOutput.getInstance();
		
		// initialize auto stuff here for drop
	}
	
	public void doWork(){
		robotOut.dropSolenoid1.set(false);
		robotOut.dropSolenoid2.set(true);
		robotOut.setDrop(false);
	}
}
