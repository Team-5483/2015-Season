package org.usfirst.frc.team5483.io;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;

public class RobotOutput {
	private static RobotOutput instance;
	public Compressor compressor;
	
	public Solenoid liftSolenoid1;
	public Solenoid liftSolenoid2;
	public Solenoid squeezeSolenoid1;
	public Solenoid squeezeSolenoid2;
	public Solenoid dropSolenoid1;
	public Solenoid dropSolenoid2;
	public boolean squeezeV;
	public boolean liftV;
	public boolean dropV;
	
	public RobotDrive myRobot;
	public Joystick stick;
	public Joystick bigStick;
	public boolean Xbutton;
	public boolean LB;
	public boolean RB;
	public boolean off;
	public Victor liftWinch; 
	

	public RobotOutput() {
		this.myRobot = new RobotDrive(0,1);
		myRobot.setMaxOutput(0.8);
		myRobot.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
		myRobot.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
		myRobot.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
		myRobot.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
		
		this.squeezeV = false;
		this.liftV = false;
		this.dropV = false;
		this.off = false;
		
		/*--------------Lift Solenoid has to be plugged into 0 and 1--------------------*/
		this.liftSolenoid1 = new Solenoid(0);
		this.liftSolenoid1.set(off);
		this.liftSolenoid2 = new Solenoid(1);
		this.liftSolenoid2.set(off);
		
		/*--------------Arm Solenoid has to be plugged into 2 and 3---------------------*/
		this.squeezeSolenoid1 = new Solenoid(2);
		this.squeezeSolenoid1.set(off);
		this.squeezeSolenoid2 = new Solenoid(3);
		this.squeezeSolenoid2.set(off);
		
		/*--------------Drop Solenoid has to be plugged into 4 and 5--------------------*/
		this.dropSolenoid1 = new Solenoid(4);
		this.dropSolenoid1.set(off);
		this.dropSolenoid2 = new Solenoid(5);
		this.dropSolenoid2.set(off);
		/*this.armDS1 = new DoubleSolenoid(0,1);
		this.armDS1.set(Value.kReverse);*/
		
		
		this.compressor = new Compressor();
		this.compressor.start();
		
	
		//this.leftDrive = new Talon(1);
		//this.rightDrive = new Talon(0);
		
		//this.liftWinch = new Victor(2);
		
		this.stick = new Joystick(0);
		//this.bigStick = new Joystick(1);
		
	
	}
	
	public static RobotOutput getInstance() {
		if (RobotOutput.instance == null){
				RobotOutput.instance = new RobotOutput();
		}
		return RobotOutput.instance; 
	}
	
	public boolean getX(){
		return this.Xbutton = stick.getRawButton(1);
	}
	
	public boolean getLB(){
		return LB = stick.getRawButton(1);
	}
	
	public boolean getRB(){
		return RB = stick.getRawButton(2);
	}
	/*public double getBSY(){
		if(stick.getRawButton(2)){
			return 0.8;
		}else{
			return 0;
		}
	}*/
	
	
	public boolean getSqueeze() {
		return squeezeV;
	}
	
	public void setExtend(boolean squeezeValue) {
		squeezeV = squeezeValue;
	}
	public boolean getLift() {
		return liftV;
	}
	
	public void setLift(boolean liftValue) {
		liftV = liftValue;
	}
	public boolean getDrop() {
		return dropV;
	}
	
	public void setDrop(boolean dropValue) {
		dropV = dropValue;
	}
}
