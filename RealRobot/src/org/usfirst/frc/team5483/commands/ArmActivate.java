package org.usfirst.frc.team5483.commands;

import org.usfirst.frc.team5483.io.RobotOutput;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Relay.Value;

import org.usfirst.frc.team5483.robot.*;

public class ArmActivate {
	
	private static int armActivations = 0;
	private static RobotOutput robotOut;
	private static Controller controller;
	public static void armInit() {
		robotOut = new RobotOutput();
	}
	
	public static void armUpdate() {
		
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
		
		while(controller.getRB() == true){
			robotOut.relay1.set(Value.kForward);
		}
		
		while(controller.getLB() == true){
			robotOut.relay1.set(Value.kReverse);
		}
		
		if(controller.getB()){
			robotOut.relay1.set(Value.kOff);
		}
		
		if(armActivations == 7000) armActivations = 0;
	}
	
	public static void activationsReset() {
		armActivations = 0;
	}
	
	public int getActivations() {
		return armActivations;
	}
}
