package org.usfirst.frc.team5483.auton.mode;

import org.usfirst.frc.team5483.auton.AutoComd;
import org.usfirst.frc.team5483.auton.AutonBuilder;
import org.usfirst.frc.team5483.auton.commands.AutoDrop;
import org.usfirst.frc.team5483.auton.commands.AutoLift;
import org.usfirst.frc.team5483.auton.commands.AutoSqueeze;
import org.usfirst.frc.team5483.auton.commands.Drive;
import org.usfirst.frc.team5483.auton.commands.Turn;

import edu.wpi.first.wpilibj.Timer;

public class TwoRCOwnSide {
	public AutoComd[] getMode() {
		AutonBuilder ab = new AutonBuilder();
        
        ab.addCommand(new AutoDrop());
        Timer.delay(2);//time for the arms to drop
        ab.addCommand(new AutoSqueeze());
        Timer.delay(0.5);//time for squeeze
        ab.addCommand(new AutoLift());
        Timer.delay(0.5);//time for lift to start
        ab.addCommand(new Turn(90));//may have to be -90
        ab.addCommand(new Drive(0));
        ab.addCommand(new Turn(-90));
        ab.addCommand(new AutoLift());
        Timer.delay(1.5);//time to drop
        ab.addCommand(new AutoSqueeze());
        
        return ab.getAutonList();
	}
}
