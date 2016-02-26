package com.autodesk.rallyuploader.services;
import java.awt.event.*;
import java.io.Serializable;

import javax.swing.*;

import com.autodesk.rallyuploader.utils.UploaderUtility;

public class ProgressMonitoring extends JFrame implements ActionListener,Serializable {
	private static final long serialVersionUID = -5825843675744860162L;
	static ProgressMonitor pbar;
	static int counter = 0;
	private String file_path;

	public ProgressMonitoring(String file_path) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pbar = new ProgressMonitor(null, "Monitoring Progress",
				"Initializing . . .", 0,100);
		Timer timer = new Timer(100, this);
		timer.start();
	}

	public static void main(String file_path) {
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
		this.setFile_path(file_path);
		return UploaderUtility.getTotalnoofcellls(file_path);

	}

	public String getFile_path() {
		return file_path;
	}

	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
}