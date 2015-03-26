package org.usfirst.frc.team5483.auton.commands;

import org.usfirst.frc.team5483.auton.AutoComd;
import org.usfirst.frc.team5483.io.RobotOutput;

public class AutoDrop extends AutoComd{
	RobotOutput robotOut;
	private boolean dropV = robotOut.getDrop();
	
	public AutoDrop(){
		super(AutoComd.CMD_DROP);
		this.robotOut = RobotOutput.getInstance();
		
		// initialize auto stuff here for drop
	}
	
	
	public boolean calculate() {
		if(dropV == false){
			robotOut.dropSolenoid1.set(false);/*-----------TODO:might need to invert values depending on how it is connected-----------*/
			robotOut.dropSolenoid2.set(true);
			robotOut.setDrop(true);
			return true;	
		}else{
			robotOut.dropSolenoid1.set(true);/*-----------TODO:might need to invert values depending on how it is connected-----------*/
			robotOut.dropSolenoid2.set(false);
			robotOut.setDrop(false);
			return true;
		}
	}
}
