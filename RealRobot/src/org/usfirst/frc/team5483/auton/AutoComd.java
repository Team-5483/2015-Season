package org.usfirst.frc.team5483.auton;



public abstract class AutoComd {

	  public static final int CMD_UTIL = 0;
	  public static final int CMD_DRIVE = 1;
	  public static final int CMD_DROP = 2;
	  public static final int CMD_SQUEEZE = 3;
	  public static final int CMD_LIFT = 4;

	    
	    private static AutoComd[] autonComponents = new AutoComd[5];
	    
	    private int cmd;
	    
	    public AutoComd(int type) {
	        this.cmd = type;
	    }
	    
	    public abstract boolean calculate();
	    
	    public boolean checkAndRun() {
	        // is something already running for this component
	        if(autonComponents[this.cmd] == null) {
	            // if not run it
	            autonComponents[this.cmd] = this;
	            return true;
	        } else {
	            return false;
	        }
	    }
	    
	    public static void execute() {
	        for(int i = 0; i < autonComponents.length; i++) {
	            // if that component has a command running
	            if(autonComponents[i] != null) {
	                // run command
	                
	                boolean done = autonComponents[i].calculate();
	                // finished, so remove
	                if(done) {
	                    autonComponents[i] = null;
	                }
	            }
	        }
	    }
	    
	    public static void overrideComponent(int typeToOverride) { 
	    	//dont forget they start at 0
	        autonComponents[typeToOverride] = null;
	    }
	    
	    public static void reset() {
	        for(int i = 0; i < autonComponents.length; i++) {
	            autonComponents[i] = null;
	        }
	    }
	    
	  
	}



