package org.usfirst.frc.team5483.auton.commands;

import org.usfirst.frc.team5483.auton.AutoComd;
import org.usfirst.frc.team5483.io.GDGyro;
import org.usfirst.frc.team5483.io.GDLib;
import org.usfirst.frc.team5483.io.GDPID;
import org.usfirst.frc.team5483.io.RobotOutput;

	import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

	public class Turn extends AutoComd {

		private GDGyro gyro;
	    private RobotOutput robotOut;
	    
	    private GDPID gyroControl;
	    
	    
	    private boolean firstCycle;
	    private double goalAngle;
	    
	    private double pConst = 0.08;
	    private double iConst = 0.01;
	    private double dConst = 0.3;
	    private int errorEpsilon = 5;
	    
	    private final String SD_P_CONST = "DT_P_CONST";
	    private final String SD_I_CONST = "DT_I_CONST";
	    private final String SD_D_CONST = "DT_D_CONST";
	    private final String SD_ERROR_EPSILON = "DT_EPSILON_VALUE";
	    
	    public Turn(double degrees) {
	        super(AutoComd.CMD_DRIVE);
	        
	        this.robotOut = RobotOutput.getInstance();
	        
	        this.goalAngle = degrees;
	        this.firstCycle = true;
	        
	        SmartDashboard.putNumber(this.SD_P_CONST, 0);
	    	SmartDashboard.putNumber(this.SD_I_CONST, 0);
	    	SmartDashboard.putNumber(this.SD_D_CONST, 0);
	    	SmartDashboard.putNumber(this.SD_ERROR_EPSILON, 0);
	        pConst = SmartDashboard.getNumber(this.SD_P_CONST);
	        iConst = SmartDashboard.getNumber(this.SD_I_CONST);
	        dConst = SmartDashboard.getNumber(this.SD_D_CONST);
	        
	        // Default PID values 
	        this.gyroControl = new GDPID(0.08, 0.01, 0.3, 5);
	        this.gyroControl.setErrorEpsilon(5);
	        this.gyroControl.setDoneRange(5);
	        this.gyroControl.setMinDoneCycles(5);
	        // TODO: update values
	    }
	    
	    public Turn(double degrees, int minDoneCycles) {
	        this(degrees);
	    }
	    
	    public Turn(double degrees, double maxSpeed) {
	        this(degrees);
	        this.gyroControl.setMaxOutput(maxSpeed);
	    }
	    
	    public boolean calculate() {
	        // TODO: smart dashboard PID constant setting
	    	SmartDashboard.putNumber(this.SD_P_CONST, 0);
	    	SmartDashboard.putNumber(this.SD_I_CONST, 0);
	    	SmartDashboard.putNumber(this.SD_D_CONST, 0);
	    	SmartDashboard.putNumber(this.SD_ERROR_EPSILON, 0);
	       pConst = SmartDashboard.getNumber(this.SD_P_CONST);
	       iConst = SmartDashboard.getNumber(this.SD_I_CONST);
	       dConst = SmartDashboard.getNumber(this.SD_D_CONST);
	       errorEpsilon = (int)SmartDashboard.getNumber(this.SD_ERROR_EPSILON);
	       
	       this.gyroControl.setConstants(pConst, iConst, dConst);
	       this.gyroControl.setErrorEpsilon(errorEpsilon);

	        if(this.firstCycle) {
	            this.firstCycle = false;
	            
	            this.gyroControl.setDesiredValue(this.gyro.getAngle() + this.goalAngle);

	        }
	        
	        double xVal = -this.gyroControl.calcPID(this.gyro.getAngle());//TODO: check if needs to be +
	        double yVal = 0.0;  // TODO: see if needs to be controlled
	        
	        double leftDrive = GDLib.calcLeftDrive(xVal, yVal);
	        double rightDrive = GDLib.calcRightDrive(xVal, yVal);
	        
	        if(this.gyroControl.isDone()) {
	            // turn everything off
	            this.robotOut.setLeftDrive(0.0);
	            this.robotOut.setRightDrive(0.0);
	            return true;
	        } else {
	            // not done yet
	        	this.robotOut.setLeftDrive(leftDrive);
	            this.robotOut.setRightDrive(rightDrive);
	            return false;
	        }
	    }
	    
	    
}



