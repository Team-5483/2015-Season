package org.usfirst.frc.team5483.commands;

import org.usfirst.frc.team5483.io.RobotOutput;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Relay.Value;

import org.usfirst.frc.team5483.robot.*;

public class ArmActivate {
	
	private static int armActivations = 0;
	RobotOutput robotOut;
	Controller controller;
	
	public void armUpdate() {
		// check condition of pneumatic, then depending on condition, change condition when x is pressed
		if(RobotOutput.getExtend() == false && controller.getX()) {
			robotOut.armSolenoid.set(DoubleSolenoid.Value.kForward);
			robotOut.setExtend(true);
			armActivations++;
		}
		if(RobotOutput.getExtend() == true && controller.getX()) {
			robotOut.armSolenoid.set(DoubleSolenoid.Value.kReverse);
			robotOut.setExtend(false);
			armActivations++;
		}
		//simple up and down of winch, might need to invert depending on how it ends up working
		while(this.controller.getRB() == true){
			robotOut.relay1.set(Value.kForward);
		}
		
		while(this.controller.getLB() == true){
			robotOut.relay1.set(Value.kReverse);
		}
		//if things go wrong b should disable it
		if(this.controller.getB()){
			robotOut.relay1.set(Value.kOff);
		}
	}
	
	public static void activationsReset() {
		armActivations = 0;
	}
	
	public int getActivations() {
		return armActivations;
	}
}
