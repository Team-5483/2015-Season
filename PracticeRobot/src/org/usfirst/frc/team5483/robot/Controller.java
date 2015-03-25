package org.usfirst.frc.team5483.robot;

import edu.wpi.first.wpilibj.Joystick;

public class Controller {
	private Joystick joystick;
	
	public Controller(int port) {
		joystick = new Joystick(port);
	}
	/** Returns the value of the trigger with a deadzone. */
	public static double getTriggerValue(double triggerValue) {
		return Math.abs(triggerValue) < 0.15 ? 0 : triggerValue;
	}

	public boolean getDPadLeft() {
		return this.joystick.getRawAxis(6) < -0.5;
	}

	public boolean getDPadRight() {
		return this.joystick.getRawAxis(6) > 0.5;
	}

	/** Is the left bumper pressed? [top one] */
	public boolean getLB() {
		return this.joystick.getRawButton(5);
	}

	/** Is the right bumper pressed? [top one] */
	public boolean getRB() {
		return this.joystick.getRawButton(5);
	}

	public boolean getA() {
		return this.joystick.getRawButton(1);
	}

	public boolean getB() {
		return this.joystick.getRawButton(2);
	}

	public boolean getX() {
		return this.joystick.getRawButton(3);
	}

	public boolean getY() {
		return this.joystick.getRawButton(4);
	}

	public boolean getStart() {
		return this.joystick.getRawButton(8);
	}

	public boolean getBack(){
		return this.joystick.getRawButton(7);
	}
}
