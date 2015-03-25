package org.usfirst.frc.team5483.telecommands;


import org.usfirst.frc.team5483.io.GDLib;
import org.usfirst.frc.team5483.io.GDPID;
import org.usfirst.frc.team5483.io.RobotOutput;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TeleDrive implements TeleopComponent{
    private static TeleDrive instance;
    private RobotOutput robotOut;
    private double xVal;
    private double yVal;
    
    private double driveForwardTime = 40;
    private double driveForwardSpeed = 0.2;
   
    
    private final String SD_DRIVE_FORWARD_TIME = "Drive Forward Time";
    private final String SD_DRIVE_FORWARD_SPEED = "Drive Forward Speed";
            

    public static TeleDrive getInstance() {
        if(instance == null) {
            instance = new TeleDrive();
        }
        return instance;
    }


    private TeleDrive() {
        
        SmartDashboard.putNumber(SD_DRIVE_FORWARD_TIME, driveForwardTime);
        SmartDashboard.putNumber(SD_DRIVE_FORWARD_SPEED, driveForwardSpeed);
        
        this.robotOut = RobotOutput.getInstance();
   
    }

    public void doWork() {
        double xInput = GDLib.squareMaintainSign(robotOut.getRightX());
        double yInput = robotOut.getLeftY();
        double leftOut = GDLib.calcLeftDrive(xInput, yInput);
        double rightOut = GDLib.calcRightDrive(xInput, yInput);
        
    
        this.robotOut.setLeftDrive(leftOut);
        this.robotOut.setRightDrive(rightOut);
        
        
    }

	public void shutDown() {
		this.robotOut.setRightDrive(0);
		this.robotOut.setLeftDrive(0);
		
	}
}