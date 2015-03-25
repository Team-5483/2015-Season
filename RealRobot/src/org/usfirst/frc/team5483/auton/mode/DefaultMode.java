package org.usfirst.frc.team5483.auton.mode;


import org.usfirst.frc.team5483.auton.*;
import org.usfirst.frc.team5483.auton.commands.*;

import edu.wpi.first.wpilibj.Timer;

public class DefaultMode implements AutonomousMode{

	
	public AutoComd[] getMode() {
		AutonBuilder ab = new AutonBuilder();
        
        ab.addCommand(new DriveForward(2));//driveForwards for 2 seconds
        
            
        
        return ab.getAutonList();
	}
	
}
