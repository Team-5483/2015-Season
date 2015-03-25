package org.usfirst.frc.team5483.auton;

import org.simbotics.simbot2014bt.auton.AutonCommand;
import org.simbotics.simbot2014bt.auton.AutonControl;

public class AutonStop extends AutoComd{

    public AutonStop() {
        super(AutoComd.CMD_UTIL);
    }
    
    public boolean calculate() {
        AutonControl.getInstance().stop();
        return true;
    }
}
