package com.autodesk.rallyuploader.services;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class JFilePicker extends JPanel implements Serializable{
	private static final long serialVersionUID = 4559968042398599025L;
	private String textFieldLabel;
	private String buttonLabel;
	private JLabel file_label;
	private JTextField textField;
	private JButton button;
	public JFileChooser fileChooser;
	private int mode;
	public static final int MODE_OPEN = 1;
	public static final int MODE_SAVE = 2;

	public JFilePicker(String textFieldLabel, String buttonLabel) {
		this.textFieldLabel = textFieldLabel;
		this.buttonLabel = buttonLabel;
		fileChooser = new JFileChooser();
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		file_label = new JLabel(textFieldLabel);
		textField = new JTextField(25);
		button = new JButton(buttonLabel);
		Font font = new Font("Verdana", Font.BOLD, 15);
		textField.setFont(font);
		textField.setForeground(Color.DARK_GRAY);
		file_label.setFont(font);
		file_label.setForeground(Color.DARK_GRAY);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				try {
					buttonActionPerformed(evt);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		add(file_label);
		add(textField);
		add(button);
	}

	private void buttonActionPerformed(ActionEvent evt)
			throws InterruptedException {
		if (mode == MODE_OPEN) {
			if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
				textField.setText(fileChooser.getSelectedFile()
						.getAbsolutePath());
			}
		}
	}

	public void addFileTypeFilter() {
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"XLSX & XLS Files", "xlsx", "xls");
		fileChooser.setFileFilter(filter);
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