package org.usfirst.frc.team5483.io;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Talon;

public class RobotOutput {
	private static RobotOutput instance;
	public Compressor compressor;
	public DoubleSolenoid armSolenoid;
	public Talon leftDrive;
	public Talon rightDrive;
	private Relay relay1;
	//public Talon claw; *just in case we end up using a winch and closing claw system*
	//public Talon winch;
	
	public Joystick joystick;

	public RobotOutput(){
		this.armSolenoid = new DoubleSolenoid (1,2);
		this.compressor = new Compressor(1);
		this.leftDrive = new Talon(1);
		this.rightDrive = new Talon(2);
		this.joystick = new Joystick(1);
		this.relay1 = new Relay(1);
	}
	
	public static RobotOutput getInstance(){
		if (RobotOutput.instance == null){
			RobotOutput.instance = new RobotOutput();
		}
		return RobotOutput.instance; 
	}
}
