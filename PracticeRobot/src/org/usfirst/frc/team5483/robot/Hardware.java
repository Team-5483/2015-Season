package org.usfirst.frc.team5483.robot;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.RobotDrive;

public class Hardware 
{

	/** This class initializes the Robot hardware */
	
	/*               [Front]              
		+--------------------------------+
		|         |Machine Gun|          |
		|          -----------           |
		|                                |
		|                                |
		|                                |
		|                                |
		+---------+            +---------+
		|         |            |         |
		|         |            |         |
		| Jaguar  |            | Jaguar  |
		|  Left   |            |  Right  |
		|         |            |         |
		|         |            |         |
		+---------+            +---------+
		|                                |
		|                                |
		|                                |
		|                                |
		|           __________           |
		|          |Tesla Coil|          |
		+--------------------------------+
-	*/
	
	public static RobotDrive chassis;
	public static Jaguar leftDriveMotor;
	public static Jaguar rightDriveMotor;
	private static boolean lInverted = false,rInverted = false;
	
	public static void init()	{
		leftDriveMotor = new Jaguar(1);
		rightDriveMotor = new Jaguar(2);
		chassis = new RobotDrive(leftDriveMotor.getChannel(), rightDriveMotor.getChannel());
	}
	
	public static void invertLeftMotors(){
		if(lInverted){
			lInverted = false;
			chassis.setInvertedMotor(RobotDrive.MotorType.kRearLeft, false);
			chassis.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, false);
		}else{
			lInverted = true;
			chassis.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
			chassis.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);	
		}
	}
	
	public static void invertRightMotors(){
		if(rInverted){
			rInverted = false;
			chassis.setInvertedMotor(RobotDrive.MotorType.kRearRight, false);
			chassis.setInvertedMotor(RobotDrive.MotorType.kFrontRight, false);
		}else{
			rInverted = true;
			chassis.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
			chassis.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);	
		}
	}
}