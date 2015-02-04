package org.usfirst.frc.team5483.robot;

import org.usfirst.frc.team5483.commands.ArmActivate;
import org.usfirst.frc.team5483.io.RobotOutput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Robot extends IterativeRobot {
	RobotOutput roboOut;
	ArmActivate arm;
	long autoLoopCounter;
	double time;
	boolean safeMode = false;
	
	
	public void robotInit() {
    	this.roboOut = RobotOutput.getInstance();
    	ArmActivate.activationsReset();

    }
      
    public void autonomousInit() {
    	//time = System.currentTimeMillis();
    	
    }

    public void autonomousPeriodic() {
    	while(isAutonomous() && isEnabled()){
    		while( time / 1000 <= 3 ) { //Check if 15 seconds have passed
    		roboOut.myRobot.drive(-0.5, 0.0); 	// drive forwards half speed
    		}
    	}
    }
    
    public void teleopInit(){
    	//initialize stuff..
    }

    public void teleopPeriodic() {
     while(isOperatorControl() && isEnabled()){ 
    	roboOut.myRobot.setSafetyEnabled(true);
    	roboOut.myRobot.arcadeDrive(roboOut.joystick);
    	Timer.delay(0.01);
        this.arm.armUpdate();
        
      }
    } 
    
    public void testPeriodic() {
    	LiveWindow.run();
    }
    
}
