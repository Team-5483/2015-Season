package org.usfirst.frc.team5483.robot;

import edu.wpi.first.wpilibj.Joystick;

public class Controller {
	/** Primary Driver Controller Port Number. */
	private static final int DRIVER_PRIMARY = 1;

	/** Secondary Driver Controller Port Number. */
	private static final int DRIVER_SECONDARY = 2;

	/** XBOX 360 South Face Button */
	private static final int BUTTON_A = 1;

	/** XBOX 360 East Face Button */
	private static final int BUTTON_B = 2;

	/** XBOX 360 West Face Button */
	private static final int BUTTON_X = 3;

	/** XBOX 360 North Face Button  */
	private static final int BUTTON_Y = 4;
	
	/** XBOX 360 Left Bumper (Top) */
	private static final int BUTTON_LB = 5;

	/** XBOX 360 Right Bumper (Top) */
	private static final int BUTTON_RB = 6;

	/** XBOX 360 Back Button */
	private static final int BUTTON_BACK = 7;

	/** XBOX 360 Start Button */
	private static final int BUTTON_START = 8;

	/** XBOX 360 Left Horizontal Axis (Left=-1, Right=1) */
	private static final int AXIS_LEFT_X = 1;

	/** XBOX 360 Left Vertical Axis (Up=-1, Down=1) */
	private static final int AXIS_LEFT_Y = 2;

	/** XBOX 360 Trigger Axis (right - left) */
	private static final int AXIS_TRIGGERS = 3;

	/**  XBOX 360 Right Horizontal Axis (Left=-1, Right=1) */
	private static final int AXIS_RIGHT_X = 4;

	/** XBOX 360 Right Vertical Axis (Up=-1, Down=1) */
	private static final int AXIS_RIGHT_Y = 5;

	/** XBOX 360 Horizontal D-PAD */
	private static final int AXIS_DPAD_HORIZONTAL = 6;

	private Controller(int port, int port2) {
		//joystick = new Joystick(port);
		//joystick2 = new Joystick (port2);
	}
	
	public static Controller controller = new Controller(1,2);
	

	/** Returns the value of the trigger with a deadzone. */
	public static double getTriggerValue(double triggerValue) {
		return Math.abs(triggerValue) < 0.15 ? 0 : triggerValue;
	}

	public boolean getDPadLeft() {
		return false;//joystick.getRawAxis(AXIS_DPAD_HORIZONTAL) < -0.5;
	}

	public boolean getDPadRight() {
		return false; //joystick.getRawAxis(AXIS_DPAD_HORIZONTAL) > 0.5;
	}

	/** Is the left bumper pressed? [top one] */
	public boolean getLB() {
		return false;//joystick.getRawButton(BUTTON_LB);
	}

	/** Is the right bumper pressed? [top one] */
	public boolean getRB() {
		return false;//joystick.getRawButton(BUTTON_RB);
	}

	public boolean getA() {
		return false;//joystick.getRawButton(BUTTON_A);
	}

	public boolean getB() {
		return false;//joystick.getRawButton(BUTTON_B);
	}

	public boolean getX() {
		return false;//joystick.getRawButton(BUTTON_X);
	}

	public boolean getY() {
		return false;//joystick.getRawButton(BUTTON_Y);
	}

	public boolean getStart() {
		return false;//joystick.getRawButton(BUTTON_START);
	}

	public boolean getBack(){
		return false;//joystick.getRawButton(BUTTON_BACK);
	}
}
