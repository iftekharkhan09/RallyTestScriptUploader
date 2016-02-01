package com.autodesk.rallyuploader.services;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.border.Border;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.autodesk.rallyuploader.services.ProgressBar.thread1;

public class JFilePicker extends JPanel {
	private String textFieldLabel;
	private String buttonLabel;
	private JLabel label;
	private JTextField textField;
	private JButton button;
	private JFileChooser fileChooser;
	private int mode;
	public static final int MODE_OPEN = 1;
	public static final int MODE_SAVE = 2;

	public JFilePicker(String textFieldLabel, String buttonLabel) {
		this.textFieldLabel = textFieldLabel;
		this.buttonLabel = buttonLabel;
		fileChooser = new JFileChooser();
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		label = new JLabel(textFieldLabel);
		textField = new JTextField(25);
		button = new JButton(buttonLabel);
		Font font = new Font("Verdana", Font.BOLD, 15);
		textField.setFont(font);
		textField.setForeground(Color.DARK_GRAY);
		label.setFont(font);
		label.setForeground(Color.DARK_GRAY);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				try {
					buttonActionPerformed(evt);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		add(label);
		add(textField);
		add(button);
	}

	private void buttonActionPerformed(ActionEvent evt) throws InterruptedException {
		if (mode == MODE_OPEN) {
			if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
				textField.setText(fileChooser.getSelectedFile()
						.getAbsolutePath());
				ProgressBar progressBar = new ProgressBar();
				new Thread(new ProgressBar.thread1()).start();
			}
		}
	}

	public void addFileTypeFilter(String extension, String description) {
		FileTypeFilter filter = new FileTypeFilter(extension, description);
		fileChooser.addChoosableFileFilter(filter);
	}

	public void setMode(int mode) {
		this.mode = mode;
	}

	public String getSelectedFilePath() {
		return textField.getText();
	}

	public JFileChooser getFileChooser() {
		return this.fileChooser;
	}
}