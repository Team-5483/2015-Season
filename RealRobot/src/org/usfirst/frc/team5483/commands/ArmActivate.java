package org.usfirst.frc.team5483.commands;

import org.usfirst.frc.team5483.io.RobotOutput;

import edu.wpi.first.wpilibj.DoubleSolenoid;

import org.usfirst.frc.team5483.robot.*;

public class ArmActivate {
		
	private static int armActivations = 0;
	private static RobotOutput robotOut;
	
	public static void armInit() {
		robotOut = new RobotOutput();
	}
	
	public static void armUpdate() {
		double triggerValue = 0;
		if(Controller.getTriggerValue(triggerValue) < 0) {
			robotOut.armSolenoid.set(DoubleSolenoid.Value.kForward);
			armActivations++;
		}
		if(Controller.getTriggerValue(triggerValue) > 0) {
			robotOut.armSolenoid.set(DoubleSolenoid.Value.kReverse);
			armActivations++;
			System.out.println("should be reversing");
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
