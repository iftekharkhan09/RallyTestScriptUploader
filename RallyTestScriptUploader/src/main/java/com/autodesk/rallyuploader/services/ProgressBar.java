package com.autodesk.rallyuploader.services;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

public class ProgressBar{ 
	static JFrame frmMain;
	static Container pane;
	static JButton btnDo;
	static JProgressBar barDo;
	public ProgressBar() throws InterruptedException{ 
		SwingFileChooserDemo swingFileChooserDemo=new SwingFileChooserDemo();
	JProgressBar progressBar = new JProgressBar();
	  //  progressBar.setValue(25);
	  //  progressBar.setStringPainted(true);
	    Border border = BorderFactory.createTitledBorder("Reading...");
	    progressBar.setBorder(border);
	    swingFileChooserDemo.add(progressBar, BorderLayout.SOUTH);
	}
	public static class thread1 implements Runnable{
		public void run(){
			for (int i=0; i<=100; i++){ //Progressively increment variable i
				barDo.setValue(i); //Set value
				barDo.repaint(); //Refresh graphics
				try{Thread.sleep(50);} //Sleep 50 milliseconds
				catch (InterruptedException err){}
			}
		}
	}
}