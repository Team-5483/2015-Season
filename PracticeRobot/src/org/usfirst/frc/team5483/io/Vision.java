package org.usfirst.frc.team5483.io;

import org.usfirst.frc.team5483.telecommands.TeleDrive;
import org.usfirst.frc.team5483.telecommands.TeleopComponent;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.ShapeMode;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Timer;

public class Vision {

	int session;
	Image frame;
	
	public void visionInit(){
		
		this.frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);

        // the camera name ("GDCam") can be found through the Roborio web interface
       
		this.session = NIVision.IMAQdxOpenCamera("GDCam",
                NIVision.IMAQdxCameraControlMode.CameraControlModeController);
        NIVision.IMAQdxConfigureGrab(session);
	}
	
	public void update(){
		 NIVision.IMAQdxStartAcquisition(session);

	        /**
	         * grab an image, draw the circle, and provide it for the camera server
	         * which will in turn send it to the dashboard.
	         */
	        NIVision.Rect rect = new NIVision.Rect(10, 10, 100, 100);

	        NIVision.IMAQdxGrab(session, frame, 1);
	        NIVision.imaqDrawShapeOnImage(frame, frame, rect,
	                   DrawMode.DRAW_VALUE, ShapeMode.SHAPE_OVAL, 0.0f);
	            
	        CameraServer.getInstance().setImage(frame);

	        Timer.delay(0.005);		// wait for a motor update time
	       
	        /*---------might need to work the timer and next line around robot code---------------*/
	        
	        NIVision.IMAQdxStopAcquisition(session);
	}
	
}
