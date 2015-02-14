package org.usfirst.frc.team5483.telecommands;

import org.usfirst.frc.team5483.io.RobotOutput;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TeleSqueeze {
		
		private RobotOutput robotOut;
		private static TeleSqueeze instance;
		
		
		public TeleSqueeze(){
			this.robotOut = RobotOutput.getInstance();
			//add controllerOutput and other intializing stuff here
		}
		
		public void doWork(){
			if(this.robotOut.stick.getRawButton(1) && robotOut.getSqueeze() == false){
				robotOut.squeezeSolenoid1.set(true);
				robotOut.squeezeSolenoid2.set(false);
				robotOut.setExtend(true);
				SmartDashboard.putBoolean("Squeeze value", robotOut.getSqueeze());
			}else if(robotOut.stick.getRawButton(1)&& robotOut.getSqueeze() == true){
				robotOut.squeezeSolenoid1.set(false);
				robotOut.squeezeSolenoid2.set(true);
				robotOut.setExtend(false);
				SmartDashboard.putBoolean("Squeeze value", robotOut.getSqueeze());
			}
		}
		
		public void shutDown(){
			robotOut.squeezeSolenoid1.set(false);
			robotOut.squeezeSolenoid2.set(false);
		}
		public static TeleSqueeze getInstance() {
			if (TeleSqueeze.instance == null){
				TeleSqueeze.instance = new TeleSqueeze();
			}
			return TeleSqueeze.instance; 
		}
		
	}


