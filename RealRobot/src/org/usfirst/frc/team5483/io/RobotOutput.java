package org.usfirst.frc.team5483.io;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;

public class RobotOutput {
	private static RobotOutput instance;
	public Compressor compressor;
	public DoubleSolenoid armSolenoid;
	public Talon leftDrive;
	public Talon rightDrive;
	public Relay relay1;
	public static boolean extend;
	public RobotDrive myRobot;
	public Joystick joystick;
	//public Talon claw; *just in case we end up using a winch and closing claw system*
	//public Talon winch;
	


	public RobotOutput(){
		this.armSolenoid = new DoubleSolenoid (0,1);
		this.compressor = new Compressor(1);
		this.compressor.start();
		this.leftDrive = new Talon(0);
		this.rightDrive = new Talon(1);
		this.joystick = new Joystick(1);
		this.myRobot = new RobotDrive(leftDrive,rightDrive);
		RobotOutput.extend = false;
		this.relay1 = new Relay(1);
	}
	
	public static RobotOutput getInstance(){
		if (RobotOutput.instance == null){
			RobotOutput.instance = new RobotOutput();
		}
		return RobotOutput.instance; 
	}

	public static boolean getExtend() {
		return extend;
	}

	public void setExtend(boolean extend) {
		RobotOutput.extend = extend;
		//do nothing
	}
}
