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
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Robot extends IterativeRobot {
	RobotDrive myRobot;
	RobotOutput roboOut;
	int autoLoopCounter;
	boolean safeMode = false;
	
	public void robotInit() {
    	myRobot = new RobotDrive(0,1);
    	roboOut = new RobotOutput();
    	ArmActivate.armInit();
    }
      
    public void autonomousInit() {
    	autoLoopCounter = 0;
    }

    public void autonomousPeriodic() {
    	if(autoLoopCounter < 100) { //Check if we've completed 100 loops (approximately 2 seconds)
    		myRobot.drive(-0.5, 0.0); 	// drive forwards half speed
			autoLoopCounter++;
		} else {
			myRobot.drive(0.0, 0.0); 	// stop robot
		}
    }
    
    public void teleopInit(){
    	
    }

    public void teleopPeriodic() {
        if(!safeMode) myRobot.arcadeDrive(roboOut.joystick);
        ArmActivate.armUpdate();
    }
    
    public void testPeriodic() {
    	LiveWindow.run();
    }
    
}
