package org.usfirst.frc.team5483.telecommands;

import java.util.Vector;

/* Thanks 1114 for the beta code :))*/
public class TeleopControl {
	@SuppressWarnings("rawtypes")
	public Vector teleopComponents;
    private static TeleopControl instance;
    
    public static TeleopControl getInstance() {
        if(instance == null) {
            instance = new TeleopControl();
        }
        return instance;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	public TeleopControl() {
        // GOTCHA: remember to add teleop components here!
        this.teleopComponents = new Vector();
        this.teleopComponents.addElement(TeleLift.getInstance());
        this.teleopComponents.addElement(TeleSqueeze.getInstance());
    }
    
    public void run() {
        for(int i = 0; i < this.teleopComponents.size(); i++) {
            ((TeleopComponent)this.teleopComponents.elementAt(i)).doWork();
        }
    }
    
    public void shutDown() {
        for(int i = 0; i < this.teleopComponents.size(); i++) {
            ((TeleopComponent)this.teleopComponents.elementAt(i)).shutDown();            
        }
    }
            
}

