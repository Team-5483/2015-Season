package org.usfirst.frc.team5483.robot;

import org.usfirst.frc.team5483.commands.ArmActivate;
import org.usfirst.frc.team5483.io.RobotOutput;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Robot extends IterativeRobot {
	RobotDrive myRobot;
	RobotOutput roboOut;
	long autoLoopCounter;
	double time;
	boolean safeMode = false;
	
	public void robotInit() {
    	myRobot = new RobotDrive(0,1);
    	roboOut = new RobotOutput();
    	ArmActivate.armInit();
    }
      
    public void autonomousInit() {
    	time = System.currentTimeMillis();
    	
    }

    public void autonomousPeriodic() {
    	while(isAutonomous() && isEnabled()){
    		while( time / 1000 <= 3 ) { //Check if 15 seconds have passed
    		myRobot.drive(-0.5, 0.0); 	// drive forwards half speed
    		}
    	}
    }
    
    public void teleopInit(){
    	
    }

    public void teleopPeriodic() {
      while(isOperatorControl() && isEnabled()){ 
    	myRobot.arcadeDrive(roboOut.joystick);
    	Timer.delay(0.01);
        ArmActivate.armUpdate();
      }
    } 
    
    public void testPeriodic() {
    	LiveWindow.run();
    }
    
}
