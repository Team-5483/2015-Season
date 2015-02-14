package org.usfirst.frc.team5483.robot;

import org.usfirst.frc.team5483.robot.*;
import org.usfirst.frc.team5483.telecommands.*;
import org.usfirst.frc.team5483.io.*;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	private RobotOutput robotOut;
	private TeleopControl tele;
	private long autoLoopCounter;
	private double time;
	boolean safeMode = false;
	
	
	public void robotInit() {
    	this.robotOut = RobotOutput.getInstance();
    	this.tele = TeleopControl.getInstance();
    	System.out.println(" ready to go");
    }
      
    public void autonomousInit() {
    	//time = System.currentTimeMillis();
    	System.out.println("Auto init");
    }

    public void autonomousPeriodic() {
    	/*while(isAutonomous() && isEnabled()){
    		while( time / 1000 <= 3 ) { //Check if 15 seconds have passed
    			roboOut.myRobot.drive(-0.5, 0.0); 	// drive forwards half speed
    		} 
    	}*/
    }
    
    public void teleopInit() {
    	//initialize stuff..
    	System.out.println("Tele init");
    }

  
	public void teleopPeriodic() {
    
    	//this.roboOut.myRobot.setSafetyEnabled(true);
        robotOut.myRobot.arcadeDrive(robotOut.stick,1, robotOut.stick, 4);
		this.tele.run();
		/*---------pneumatic test code---------*/
		/*if(robotOut.stick.getRawButton(1) && robotOut.getExtend() == false){
			robotOut.liftSolenoid1.set(true);
			robotOut.liftSolenoid2.set(false);
			robotOut.setExtend(true);
			SmartDashboard.putBoolean("Extend value", robotOut.getExtend());
		}
		if(robotOut.stick.getRawButton(1)&& robotOut.getExtend() == true){
			robotOut.liftSolenoid1.set(false);
			robotOut.liftSolenoid2.set(true);
			robotOut.setExtend(false);
			SmartDashboard.putBoolean("Extend value", robotOut.getExtend());
		}*/
		
	
        

  
    } 
    
    public void testPeriodic() {
    	LiveWindow.run();
    }
    
}
