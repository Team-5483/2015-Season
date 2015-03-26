package org.usfirst.frc.team5483.auton.mode;


import org.usfirst.frc.team5483.auton.AutoComd;
import org.usfirst.frc.team5483.auton.AutonBuilder;
import org.usfirst.frc.team5483.auton.AutonomousMode;
import org.usfirst.frc.team5483.auton.commands.AutoDrop;
import org.usfirst.frc.team5483.auton.commands.AutoLift;
import org.usfirst.frc.team5483.auton.commands.AutoSqueeze;
import org.usfirst.frc.team5483.auton.commands.Drive;
import org.usfirst.frc.team5483.auton.commands.Turn;

import edu.wpi.first.wpilibj.Timer;

public class DefaultMode implements AutonomousMode{

	
	public AutoComd[] getMode() {
		AutonBuilder ab = new AutonBuilder();
        
        ab.addCommand(new Drive(0));//might not stop lol TODO:make it stop
        
        
        return ab.getAutonList();
	}

}
