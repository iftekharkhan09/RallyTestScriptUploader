package com.autodesk.rallyuploader.services;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ProgressMonitoring extends JFrame implements ActionListener {

  static ProgressMonitor pbar;
  static int counter = 0;

  public ProgressMonitoring() {
    //super("Progress Monitor Demo");
    //setSize(250,100);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    pbar = new ProgressMonitor(null, "Monitoring Progress",
            "Initializing . . .", 0, 100);

    // Fire a timer every once in a while to update the progress.
    Timer timer = new Timer(500, this);
    timer.start();
   // setVisible(true);
  }

  public static void main(String args[]) {
    UIManager.put("ProgressMonitor.progressText", "Data progressing");
    UIManager.put("OptionPane.cancelButtonText", "Cancel");
    new ProgressMonitoring();
  }

  public void actionPerformed(ActionEvent e) {
    // Invoked by the timer every half second. Simply place
    // the progress monitor update on the event queue.
    SwingUtilities.invokeLater(new Update());
  }
public void execute(){
	main(null);
	SwingApplication swingApplication=new SwingApplication();
	swingApplication.btnNewButton.setEnabled(false);
}
  
  class Update implements Runnable {
    public void run() {
      if (pbar.isCanceled()) {
        pbar.close();
        System.exit(1);
      }
    pbar.setProgress(counter);
    pbar.setNote("Data Processing is "+counter+"% complete");
    counter += 1;
    }
  }
}