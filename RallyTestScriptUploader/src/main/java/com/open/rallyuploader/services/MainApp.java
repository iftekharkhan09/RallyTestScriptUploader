package com.open.rallyuploader.services;
import java.io.IOException;
import java.net.URISyntaxException;

import com.open.rallyuploader.exeption.RallyUploaderException;
public class MainApp {
	public static void main(String[] args) throws RallyUploaderException,
			IOException, InterruptedException, URISyntaxException {
		SplashScreen splashScreen=new SplashScreen(6000);
		splashScreen.showSplashScreen();
		SwingApplication swingApplication=new SwingApplication();
		swingApplication.call();
	}
}