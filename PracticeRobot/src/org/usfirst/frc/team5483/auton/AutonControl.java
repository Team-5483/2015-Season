/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team5483.auton;

//import edu.wpi.first.wpilibj.DriverStationLCD;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Vector;

import org.simbotics.simbot2014bt.auton.mode.AutonHotMode;
import org.simbotics.simbot2014bt.auton.mode.AutonMode;
import org.simbotics.simbot2014bt.auton.mode.DefaultMode;
import org.simbotics.simbot2014bt.auton.mode.DriveBack;
import org.simbotics.simbot2014bt.auton.mode.DriveForward;
import org.simbotics.simbot2014bt.auton.mode.DriveForwardNG;

import org.simbotics.simbot2014bt.auton.mode.OneBall;

import org.simbotics.simbot2014bt.auton.mode.OneBallNG;

import org.simbotics.simbot2014bt.auton.mode.TurnTest45;
import org.simbotics.simbot2014bt.auton.mode.TurnTest90;
import org.simbotics.simbot2014bt.auton.mode.TwoBallRightTurn;


import org.simbotics.simbot2014bt.auton.mode.TwoBallRightStraight;
import org.simbotics.simbot2014bt.auton.mode.TwoBallLeftStraight;
import org.simbotics.simbot2014bt.auton.mode.TwoBallLeftTurn;
import org.simbotics.simbot2014bt.io.DriverInput;
import org.simbotics.simbot2014bt.io.RobotOutput;
import org.simbotics.simbot2014bt.io.SensorInput;
import org.simbotics.simbot2014bt.utilities.Debugger;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Programmers
 */
public class AutonControl {

    public static boolean hotGoalOnRight = true;
    public static boolean hotGoalDetected;
    
    private static AutonControl instance;
    
    private int autonMode;
    private AutonMode activeMode;
    private int autonDelay;
    private long autonStartTime;
    
    private boolean running;
    private Vector autonModes;
    
    private int currIndex;
    private AutonCommand[] commands;
    
    private boolean runningHotGoalCmds = false;
    private int hotGoalCmdIndex;
    private AutonCommand[] hotGoalCommands;
    
    
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
        this.autonModes.addElement(new DriveForward());     // 1
        //this.autonModes.addElement(new OneBall());          // 2
        //this.autonModes.addElement(new OneBallWall());     // 3
        
        //this.autonModes.addElement(new OneBallHotLeft());   // 4
        //this.autonModes.addElement(new OneBallHotMiddle()); // 5
        //this.autonModes.addElement(new OneBallHotRight());  // 6 
        //this.autonModes.addElement(new TwoBallHotLeft()); // 7
        //this.autonModes.addElement(new TwoBallHotRight()); // 8
        
        
        this.autonModes.addElement(new DriveForwardNG()); // 2
        //his.autonModes.addElement(new OneBallNG()); // 14
        //this.autonModes.addElement(new OneBallHotLeftNG()); // 15
        //this.autonModes.addElement(new OneBallHotRightNG()); // 16
    
        this.autonModes.addElement(new DriveBack()); //3
        //this.autonModes.addElement(new KGoaliePickLeft()); //4 
        //this.autonModes.addElement(new KGoaliePickRight()); //5
        this.autonModes.addElement(new OneBall());//4
        this.autonModes.addElement(new OneBallNG());//5
        
        this.autonModes.addElement(new TwoBallLeftStraight()); // 6
        this.autonModes.addElement(new TwoBallRightStraight()); // 7
        this.autonModes.addElement(new TwoBallLeftTurn()); // 8
        this.autonModes.addElement(new TwoBallRightTurn()); // 9
        //this.autonModes.addElement(new TurnTest90());
        //this.autonModes.addElement(new TurnTest45());
        
        //this.autonModes.addElement(new GoaliePresetLeft()); //10
        //this.autonModes.addElement(new GoaliePresetRight()); //11
        //this.autonModes.addElement(new KinectGoalie()); //12
        //this.autonModes.addElement(new KinectGoalieCurve()); //13
        //this.autonModes.addElement(new KinectGoalieExtension());//14

        //this.autonModes.addElement(new KOneBallHotLeft()); //15
        //this.autonModes.addElement(new KOneBallHotLeftNG()); //16
        //this.autonModes.addElement(new KOneBallHotMiddle()); //17 
        //this.autonModes.addElement(new KOneBallHotRight()); //18 
        //this.autonModes.addElement(new KOneBallHotRightNG()); //19
        //this.autonModes.addElement(new KTwoBallHotLeft()); //20
        //this.autonModes.addElement(new KTwoBallHotRight()); //21
        //this.autonModes.addElement(new KTwoBallChooseMiddle()); //22
        
        //this.autonModes.addElement(new KTwoBallChooseSide());//30

        
        
        
        
        //this.autonModes.addElement(new LaneChangeTest());
       
       
        //this.autonModes.addElement(new KinectGoalieCurve1()); //test remove after testing        
       
    }

    public void initialize() {
        Debugger.println("START AUTO");
        
        AutonControl.hotGoalDetected = true; // haven't found it yet
        
        this.currIndex = 0;
        this.running = true;
        
        this.hotGoalCmdIndex = 0;
        this.runningHotGoalCmds = false;
        
        // initialize auton in runCycle to deal with hotgoal
        this.activeMode = (AutonMode)this.autonModes.elementAt(this.autonMode);
        this.commands = this.activeMode.getMode();
       
        
        if(!(this.activeMode instanceof AutonHotMode)) {
           // SensorInput.getInstance().disableCamera();
        }
        
        this.autonStartTime = System.currentTimeMillis();
        
        // clear out each components "run seat"
        AutonCommand.reset();
    }
    
    public void runCycle() {
        // haven't initialized list yet
        long timeElapsed = System.currentTimeMillis() - this.autonStartTime;
        if(timeElapsed > this.getAutonDelayLength() && this.running) {
            Debugger.println("Current index " + this.currIndex, "QTIP");
            
            if(!this.runningHotGoalCmds) {
                // start waiting commands
                while(this.currIndex < this.commands.length &&
                        this.commands[this.currIndex].checkAndRun()) {
                    this.currIndex++;
                }
            } else {
               // start waiting commands
                while(this.hotGoalCmdIndex < this.hotGoalCommands.length &&
                        this.hotGoalCommands[this.hotGoalCmdIndex].checkAndRun()) {
                    this.hotGoalCmdIndex++;
                }
            }
            // calculate call for all running commands
            AutonCommand.execute();
            RobotOutput.getInstance().setFinger(false);
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
