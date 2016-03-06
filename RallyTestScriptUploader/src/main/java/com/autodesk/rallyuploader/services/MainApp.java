package com.autodesk.rallyuploader.services;
import java.io.IOException;
import com.autodesk.rallyuploader.exeption.RallyUploaderException;
public class MainApp {
	public static void main(String[] args) throws RallyUploaderException,
			IOException, InterruptedException {
		SplashScreen splashScreen=new SplashScreen(6000);
		splashScreen.showSplashScreen();
		SwingApplication swingApplication=new SwingApplication();
		swingApplication.call();
	}
}