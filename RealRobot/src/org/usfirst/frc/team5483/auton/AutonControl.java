/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team5483.auton;


import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Vector;

import org.usfirst.frc.team5483.auton.AutonomousMode;
import org.usfirst.frc.team5483.auton.mode.DefaultMode;

import org.usfirst.frc.team5483.io.*;


import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutonControl {

    
    private static AutonControl instance;
    
    private int autonMode;
    private AutonomousMode activeMode;
    private int autonDelay;
    private long autonStartTime;
    
    private boolean running;
    private Vector autonModes;
    
    private int currIndex;
    private AutoComd[] commands;
    
    
    private String autoSelectError = "NO ERROR";
    
    public static AutonControl getInstance() {
        if(instance == null) {
            instance = new AutonControl();
        }
        return instance;
    }

    private AutonControl() {
        this.autonMode = 0;
        this.autonDelay = 0;
        this.currIndex = 0;
        
        this.autonModes = new Vector();
        
        // GOTCHA: remember to put all auton modes here
        
        
        this.autonModes.addElement(new DefaultMode());      // 0
    
       
    }

    public void initialize() {
       
        this.currIndex = 0;
        this.running = true;
        
        // initialize auton in runCycle to deal with hotgoal
        this.activeMode = (AutonomousMode)this.autonModes.elementAt(this.autonMode);
        this.commands = this.activeMode.getMode();
       
        
        this.autonStartTime = System.currentTimeMillis();
        
        // clear out each components 
        AutoComd.reset();
    }
    
    public void runCycle() {
        // haven't initialized list yet
        long timeElapsed = System.currentTimeMillis() - this.autonStartTime;
        if(timeElapsed > this.getAutonDelayLength() && this.running) {
            
            // calculate call for all running commands
            AutoComd.execute();
        } else {
            RobotOutput.getInstance().stopAll();
        }

    
    }
    
    public void stop() {
        this.running = false;
    }
    
    public long getAutonDelayLength() {
        return (long)(this.autonDelay * 500);
    }

    public void updateModes() {
        DriverInput driverIn = DriverInput.getInstance();
        
        
        try {
        
        if(driverIn.getAutonSetModeButton()) {
            double val = driverIn.getAutonSelectStick();

            
            val = (val + 1) / 2.0;  // make it positive and between 0 - 1.0
            
            // figure out which auton mode is being selected
            this.autonMode = (int)(val * this.autonModes.size());
            // make sure we didn't go off the end of the list
            this.autonMode = Math.min(autonMode, this.autonModes.size() - 1);
            if(this.autonMode < 0 ){
            	this.autonMode =0;
            }
            /*
            if(val < 0) { this.autonMode = 0; }
            else { this.autonMode = 1; }
         */   
        } else if(driverIn.getAutonSetDelayButton()) {
            this.autonDelay = (int)((driverIn.getAutonSelectStick() + 1) * 5.0);
            if(this.autonDelay < 0 ) {
            	this.autonDelay =0;
            }
        }
        
        } catch(Exception e) {
        	this.autonMode = 0;
        	
        	StringWriter sw = new StringWriter();
        	e.printStackTrace(new PrintWriter(sw));
        	
        	
        	this.autoSelectError = sw.toString();
        
        }
        
        // name of the current auton mode
        String name = this.autonModes.elementAt(this.autonMode).getClass().getName();

        // make sure there is a '.'
        if(name.lastIndexOf('.') >= 0) {
            // get just the last bit of the name
            name = name.substring(name.lastIndexOf('.'));
        }
        
        String delayAmt = "";
        if(this.autonDelay < 10) {
            // pad in a blank space for single digit delay
            delayAmt = " " + this.autonDelay;
        } else {
            delayAmt = "" + this.autonDelay;
        }
        
        String outputString = "" + (int)autonDelay + "-" + autonMode + name+"";
        //Make Smartdashboard version//
        
        SmartDashboard.putString("Auton Selector: ",outputString);
        SmartDashboard.putString("Auton Error: ", this.autoSelectError);
        
        //DriverStationLCD driverLCD = DriverStationLCD.getInstance();
        //driverLCD.println(DriverStationLCD.Line.kUser6, 1, outputString);
        //driverLCD.updateLCD();

    }
    
    public void setHotGoalMode(boolean rightSideHot) {
        AutonControl.hotGoalOnRight = rightSideHot;
        
        if(this.activeMode instanceof AutonHotMode) {
            this.runningHotGoalCmds = true;
            this.hotGoalCmdIndex = 0;
            this.hotGoalCommands = ((AutonHotMode)this.activeMode).getHotGoalList();
        }
    }
}
