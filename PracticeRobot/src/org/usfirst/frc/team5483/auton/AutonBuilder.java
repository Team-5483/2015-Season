package org.usfirst.frc.team5483.auton;

import java.util.Vector;


public class AutonBuilder {
	   private Vector cmds;
	    
	    @SuppressWarnings("rawtypes")
		public AutonBuilder() {
	        this.cmds = new Vector();
	    }
	    
	    @SuppressWarnings("unchecked")
		public void addCommand(AutoComd cmd) {
	        this.cmds.addElement(cmd);
	    }
	    
	    public AutoComd[] getAutonList() {
	        // add a stop at the end of every auton mode
	        this.cmds.addElement(new AutonStop());
	        
	        AutoComd[] result = new AutoComd[this.cmds.size()];
	        this.cmds.copyInto(result);
	        return result;
	    }
}
