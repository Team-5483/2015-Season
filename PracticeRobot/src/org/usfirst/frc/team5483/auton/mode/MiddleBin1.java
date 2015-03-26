package org.usfirst.frc.team5483.auton.mode;

import org.usfirst.frc.team5483.auton.AutoComd;
import org.usfirst.frc.team5483.auton.AutonBuilder;
import org.usfirst.frc.team5483.auton.commands.AutoDrop;
import org.usfirst.frc.team5483.auton.commands.AutoLift;
import org.usfirst.frc.team5483.auton.commands.AutoSqueeze;
import org.usfirst.frc.team5483.auton.commands.Drive;
import org.usfirst.frc.team5483.auton.commands.Turn;

import edu.wpi.first.wpilibj.Timer;

public class MiddleBin1 {
	
	public AutoComd[] getMode() {
		AutonBuilder ab = new AutonBuilder();
        
        ab.addCommand(new AutoDrop());
        Timer.delay(2);//time for the arms to drop
        ab.addCommand(new Drive(0));
        ab.addCommand(new AutoSqueeze());
        Timer.delay(0.25);//time for squeeze
        ab.addCommand(new AutoLift());
        Timer.delay(0.5);//time for lift to start
        ab.addCommand(new Turn(90));//may have to be -90
        ab.addCommand(new Drive(0));//TODO: need time and direction parameters
        /*TODO: Drive needs to be controlled by how long we want it to drive since we dont have encoders
         * it will likely have to be while(System.out.currentTimeMillis() - (time instantiated when Drive() is called))
         * we will also have to specify the direction for left and right Drive to be set to negative values
         */
        ab.addCommand(new Turn(-90));
        ab.addCommand(new AutoLift());
        Timer.delay(1.5);//time to drop
        ab.addCommand(new AutoSqueeze());
        
        return ab.getAutonList();
	}
}
