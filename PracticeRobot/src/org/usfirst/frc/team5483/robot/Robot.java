package org.usfirst.frc.team5483.robot;

import org.usfirst.frc.team5483.robot.*;
import org.usfirst.frc.team5483.telecommands.*;
import org.usfirst.frc.team5483.auton.commands.AutoDrop;
import org.usfirst.frc.team5483.auton.commands.AutoLift;
import org.usfirst.frc.team5483.auton.commands.AutoSqueeze;
import org.usfirst.frc.team5483.io.*;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	private RobotOutput robotOut;
	private TeleopControl tele;
	private Vision cam;
	private AutoLift aLift;
	private AutoSqueeze aSqueeze;
	private AutoDrop aDrop;
	boolean safeMode = false;
	
	
	public void robotInit() {
    	this.robotOut = RobotOutput.getInstance();
    	this.tele = TeleopControl.getInstance();
    	this.cam.visionInit();
    	System.out.println(" ready to go");
    }
      
    public void autonomousInit() {
    	//initialize stuff for auto
    }

    public void autonomousPeriodic() {
    	
    }
    
    public void teleopInit() {
    	//initialize stuff for tele
    	System.out.println("Tele init");
    }

  
	public void teleopPeriodic() {
        //robotOut.myRobot.arcadeDrive(robotOut.getLeftY(),robotOut.getRightX(), true);
		this.cam.update();
		this.tele.run();
		if(robotOut.stick.getRawButton(10))robotOut.compressor.stop();
		if(robotOut.stick.getRawButton(9))robotOut.compressor.start();
		
    } 
    
    public void testPeriodic() {
    	LiveWindow.run();
    }
    
}
