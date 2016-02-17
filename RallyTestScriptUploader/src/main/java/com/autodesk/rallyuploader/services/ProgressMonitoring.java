package com.autodesk.rallyuploader.services;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import com.autodesk.rallyuploader.utils.UploaderUtility;

public class ProgressMonitoring extends JFrame implements ActionListener {

	static ProgressMonitor pbar;
	static int counter = 0;
	private String file_path;

	public ProgressMonitoring(String file_path) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pbar = new ProgressMonitor(null, "Monitoring Progress",
				"Initializing . . .", 0, getTotalnoofcells(file_path));
		Timer timer = new Timer(500, this);
		timer.start();
	}

	public void main(String file_path) {
		UIManager.put("ProgressMonitor.progressText", "Data progressing");
		UIManager.put("OptionPane.cancelButtonText", "Cancel");
		new ProgressMonitoring(file_path);
	}

	public void actionPerformed(ActionEvent e) {
		SwingUtilities.invokeLater(new Update());
	}

	class Update implements Runnable {
		public void run() {
			if (pbar.isCanceled()) {
				pbar.close();
				System.exit(1);
			}
			pbar.setProgress(counter);
			pbar.setNote("Data Processing is " + counter + "% complete");
			counter += 1;
		}
	}

	public int getTotalnoofcells(String file_path) {
		this.file_path = file_path;
		return UploaderUtility.getTotalnoofcellls(file_path);

	}
}