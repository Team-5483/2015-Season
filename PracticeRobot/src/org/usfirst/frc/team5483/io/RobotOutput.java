package org.usfirst.frc.team5483.io;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
	public Victor rearLeft;
	public Victor rearRight;
	public Victor frontLeft;
	public Victor frontRight;
	public double driveOutputSpeed;
	double leftDriveSpeed;
	double rightDriveSpeed;
	public Joystick stick;
	public double frontBackAxis;
	public double leftRightAxis;
	public boolean Xbutton;
	public boolean LB;
	public boolean RB;
	public boolean off;
	public boolean on;
	
	String driveOutputValueS = "DRIVE_OUTPUT";

	
	public RobotOutput() {
		/*this.myRobot = new RobotDrive(3,0,1,2);
		this.driveOutputSpeed = 0;
		SmartDashboard.putNumber(driveOutputValueS, driveOutputSpeed);
		this.driveOutputSpeed = SmartDashboard.getNumber(driveOutputValueS);
		myRobot.setMaxOutput(driveOutputSpeed);*/
		
		this.rearLeft = new Victor (0);
		this.rearRight = new Victor(1);
		this.frontLeft = new Victor (2);
		this.frontRight = new Victor (3);
		
		/*myRobot.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
		myRobot.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
		myRobot.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
		myRobot.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);*/
		
		this.squeezeV = false;
		this.liftV = false;
		this.dropV = false;
		this.off = false;
		this.on = true;
		
		/*--------------Lift Solenoid has to be plugged into 4 and 5--------------------*/
		this.liftSolenoid1 = new Solenoid(4);
		this.liftSolenoid1.set(on);
		this.liftSolenoid2 = new Solenoid(5);
		this.liftSolenoid2.set(on);
		
		/*--------------Arm Solenoid has to be plugged into 0 and 1---------------------*/
		this.squeezeSolenoid1 = new Solenoid(0);
		this.squeezeSolenoid1.set(on);
		this.squeezeSolenoid2 = new Solenoid(1);
		this.squeezeSolenoid2.set(on);
		
		/*--------------Drop Solenoid has to be plugged into 2 and 3--------------------*/
		this.dropSolenoid1 = new Solenoid(2);
		this.dropSolenoid1.set(on);
		this.dropSolenoid2 = new Solenoid(3);
		this.dropSolenoid2.set(on);
		
		
		
		this.compressor = new Compressor();
		this.compressor.start();
		
	
		
	
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
	
	public boolean getSqueeze() {
		return squeezeV;
	}
	
	public void setSqueeze(boolean squeezeValue) {
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
	public void setLeftDrive(double val){
		rearLeft.set(val);
		frontLeft.set(val);
		leftDriveSpeed = val;
	}
	public void setRightDrive(double val){
		rearRight.set(val);
		frontRight.set(val);
		rightDriveSpeed = val;
	}
	 public double getLeftY() {
	        return this.stick.getRawAxis(1);
	    }
	    
	 public double getRightX() {
	        return this.stick.getRawAxis(4);
	    }

	public void stopAll() {
		 this.setLeftDrive(0.0);
	     this.setRightDrive(0.0);
	}
}
