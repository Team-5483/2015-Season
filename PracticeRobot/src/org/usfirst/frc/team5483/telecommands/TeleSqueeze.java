package org.usfirst.frc.team5483.telecommands;

import org.usfirst.frc.team5483.io.RobotOutput;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TeleSqueeze implements TeleopComponent{
		
		private RobotOutput robotOut;
		private static TeleSqueeze instance;
		
		
		private TeleSqueeze(){
			this.robotOut = RobotOutput.getInstance();
			//add controllerOutput and other intializing stuff here
		}
		
		public void doWork(){
			if(this.robotOut.stick.getRawButton(3) && robotOut.getSqueeze() == false){
				robotOut.squeezeSolenoid1.set(true);
				robotOut.squeezeSolenoid2.set(false);
				robotOut.setSqueeze(true);
				SmartDashboard.putBoolean("Squeeze value", robotOut.getSqueeze());
			}
			if(robotOut.stick.getRawButton(4)&& robotOut.getSqueeze() == true){
				robotOut.squeezeSolenoid1.set(false);
				robotOut.squeezeSolenoid2.set(true);
				robotOut.setSqueeze(false);
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


