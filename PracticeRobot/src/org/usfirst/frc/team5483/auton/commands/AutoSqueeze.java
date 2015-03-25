package org.usfirst.frc.team5483.auton.commands;

import org.usfirst.frc.team5483.io.RobotOutput;

public class AutoSqueeze {
	RobotOutput robotOut;
	public AutoSqueeze(){
		robotOut = RobotOutput.getInstance();
		
		// initialize auto stuff here for drop
	}
	
	public void doWork(){
		robotOut.squeezeSolenoid1.set(false);
		robotOut.squeezeSolenoid2.set(true);
		robotOut.setSqueeze(true);
	}
}
