package org.usfirst.frc.team5483.io;


public class GDLib {
	 public static double limitValue(double val) {
	        return GDLib.limitValue(val, 1.0);
	    }
	    
	    public static double limitValue(double val, double max) {
	        if(val > max) {
	            return max;
	        } else if(val < -max) {
	            return -max;
	        } else {
	            return val;
	        }
	    }
	    public static double squareMaintainSign(double val) {
	        double output = val * val;
	        
	        if(val < 0) {
	            output = -output;
	        }
	        
	        return output;
	    }
	    public static double calcLeftDrive(double x, double y) {
	        return GDLib.limitValue(y + x);
	    }
	    
	    public static double calcRightDrive(double x, double y) {
	        return GDLib.limitValue(y - x);
	    }
}
