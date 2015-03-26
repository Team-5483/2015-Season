package org.usfirst.frc.team5483.auton.commands;

import org.usfirst.frc.team5483.auton.AutoComd;
import org.usfirst.frc.team5483.io.RobotOutput;

public class AutoSqueeze extends AutoComd{
	RobotOutput robotOut;
	private boolean squeezeV = robotOut.getSqueeze();
	
	public AutoSqueeze(){
		super(AutoComd.CMD_SQUEEZE);
		this.robotOut = RobotOutput.getInstance();
		
		// initialize auto stuff here for drop
	}
	
	
	public boolean calculate() {
		if(squeezeV == false){
			robotOut.squeezeSolenoid1.set(false);/*-----------TODO:might need to invert values depending on how it is connected-----------*/
			robotOut.squeezeSolenoid2.set(true);
			robotOut.setSqueeze(true);
			return true;	
		}else{
			robotOut.squeezeSolenoid1.set(true);/*-----------TODO:might need to invert values depending on how it is connected-----------*/
			robotOut.squeezeSolenoid2.set(false);
			robotOut.setSqueeze(false);
			return true;
		}
	}
}
