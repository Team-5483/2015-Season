package org.usfirst.frc.team5483.auton;


public class AutonStop extends AutoComd{

    public AutonStop() {
        super(AutoComd.CMD_UTIL);
    }
    
    public boolean calculate() {
        AutonControl.getInstance().stop();
        return true;
    }
}
