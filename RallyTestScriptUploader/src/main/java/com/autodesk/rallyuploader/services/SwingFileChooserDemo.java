package com.autodesk.rallyuploader.services;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Insets;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import com.autodesk.rallyuploader.utils.Constants;

public class SwingFileChooserDemo extends JPanel {
	static private final String newline = "\n";
	JButton openButton, saveButton;
	JTextArea log;
	JFileChooser fc;
	static JFrame frame;
	public SwingFileChooserDemo() throws InterruptedException {
		// super(new BorderLayout());
		log = new JTextArea(5, 20);
		log.setBounds(3, 3, 300, 200);
		add(log);
		Font font = new Font("Verdana", Font.BOLD, 15);
		log.setFont(font);
		log.setForeground(Color.DARK_GRAY);
		log.setText("\n" + Constants.welcome_message + "\n");
		log.append("\n" + Constants.developer_identity + Constants.author
				+ "\n");
		log.setMargin(new Insets(5, 5, 5, 5));
		log.setEditable(false);
		JScrollPane logScrollPane = new JScrollPane(log);
		JFilePicker filePicker = new JFilePicker(Constants.test_script_path,
				"Browse...");
		TestPane testPane = new TestPane();
		filePicker.setMode(JFilePicker.MODE_OPEN);
		filePicker.addFileTypeFilter(".xls", "Xls Files");
		filePicker.addFileTypeFilter(".xlsx", "Xlsx Files");
		JFileChooser fileChooser = filePicker.getFileChooser();
		fileChooser.setCurrentDirectory(new File("C:/"));
		Container pane =frame.getContentPane();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

		pane.add(logScrollPane);
		pane.add(filePicker);
		pane.add(testPane);
	}

	/** Returns an ImageIcon, or null if the path was invalid. */
	protected static ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = SwingFileChooserDemo.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
	

	private static void createAndShowGUI() throws InterruptedException {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		 frame = new JFrame("Rally File Test Script Uploader Utility");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JComponent newContentPane = new SwingFileChooserDemo();
		newContentPane.setOpaque(true);
		frame.setContentPane(newContentPane);
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					createAndShowGUI();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
	}
}