package com.autodesk.rallyuploader.services;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

import com.autodesk.rallyuploader.utils.Constants;

import javax.swing.JPanel;
import javax.swing.JToolBar;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.SwingConstants;

import java.awt.Insets;
import java.io.File;
import java.awt.BorderLayout;

import javax.swing.JSplitPane;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.GridLayout;

import javax.swing.JTextField;

import java.awt.Component;

import javax.swing.Box;

import java.awt.FlowLayout;

import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.DropMode;

import java.awt.TextField;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class SwingApplication implements ActionListener {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_4;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JPanel panel_4;
	public JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingApplication window = new SwingApplication();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SwingApplication() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 853, 736);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(
				new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);

		JPanel panel_3 = new JPanel();

		JPanel panel_4 = new JPanel();
		panel_4.setToolTipText("Note: It is recommended to the enter the corresponding values for the above fields if the values as same fo most of the test scenerios.Otherwise,you can insert the values in the output excel sheet generated.");
		panel_4.setBorder(new CompoundBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"),
				"Please Enter the below details", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(64, 64, 64)), new LineBorder(
				new Color(64, 64, 64), 2, true)));
		panel_4.setBackground(Color.WHITE);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(Color.DARK_GRAY, 2, true));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1
				.setHorizontalGroup(gl_panel_1
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								Alignment.TRAILING,
								gl_panel_1
										.createSequentialGroup()
										.addGap(19)
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																panel_5,
																Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE,
																879,
																Short.MAX_VALUE)
														.addComponent(
																panel_4,
																GroupLayout.PREFERRED_SIZE,
																879,
																Short.MAX_VALUE)
														.addComponent(
																panel_3,
																Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE,
																879,
																Short.MAX_VALUE)
														.addComponent(
																panel_2,
																Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addContainerGap()));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel_1
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 67,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 60,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 361,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_5, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(142, Short.MAX_VALUE)));
		panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel_18 = new JLabel(
				"Click here to start the processing of the input sheet ");
		lblNewLabel_18.setFont(new Font("Verdana", Font.PLAIN, 25));
		lblNewLabel_18.setVerticalAlignment(SwingConstants.TOP);
		panel_5.add(lblNewLabel_18);

		btnNewButton = new JButton("Process test script");
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 15));
		panel_5.add(btnNewButton);

		JLabel label = new JLabel("");
		panel_5.add(label);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel_1 = new JLabel("Display Color:");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 30));
		panel_4.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(textField);
		textField.setColumns(8);

		JLabel lblNewLabel_2 = new JLabel("Expedite:");
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 30));
		panel_4.add(lblNewLabel_2);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(textField_1);
		textField_1.setColumns(8);

		JLabel lblNewLabel_3 = new JLabel("Ready:");
		lblNewLabel_3.setFont(new Font("Verdana", Font.PLAIN, 30));
		panel_4.add(lblNewLabel_3);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(textField_2);
		textField_2.setColumns(8);

		JLabel lblNewLabel_4 = new JLabel("Last Result:");
		lblNewLabel_4.setFont(new Font("Verdana", Font.PLAIN, 30));
		panel_4.add(lblNewLabel_4);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(textField_3);
		textField_3.setColumns(8);

		JLabel lblNewLabel_6 = new JLabel("Owner:");
		lblNewLabel_6.setFont(new Font("Verdana", Font.PLAIN, 30));
		panel_4.add(lblNewLabel_6);

		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(textField_5);
		textField_5.setColumns(20);

		JLabel lblNewLabel_7 = new JLabel("User Story:");
		lblNewLabel_7.setFont(new Font("Verdana", Font.PLAIN, 30));
		panel_4.add(lblNewLabel_7);

		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(textField_6);
		textField_6.setColumns(8);

		JLabel lblNewLabel_5 = new JLabel("Notes:");
		lblNewLabel_5.setFont(new Font("Verdana", Font.PLAIN, 30));
		panel_4.add(lblNewLabel_5);

		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(textField_4);
		textField_4.setColumns(28);

		JLabel lblNewLabel_8 = new JLabel("Type:");
		lblNewLabel_8.setFont(new Font("Verdana", Font.PLAIN, 30));
		panel_4.add(lblNewLabel_8);

		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(textField_7);
		textField_7.setColumns(8);

		JLabel lblNewLabel_9 = new JLabel("Method:");
		lblNewLabel_9.setFont(new Font("Verdana", Font.PLAIN, 30));
		panel_4.add(lblNewLabel_9);

		textField_8 = new JTextField();
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(textField_8);
		textField_8.setColumns(8);

		JLabel lblNewLabel_11 = new JLabel("Priority:");
		lblNewLabel_11.setFont(new Font("Verdana", Font.PLAIN, 30));
		panel_4.add(lblNewLabel_11);

		textField_12 = new JTextField();
		textField_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(textField_12);
		textField_12.setColumns(8);

		JLabel lblNewLabel_10 = new JLabel("Risk:");
		lblNewLabel_10.setFont(new Font("Verdana", Font.PLAIN, 30));
		panel_4.add(lblNewLabel_10);

		textField_13 = new JTextField();
		textField_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(textField_13);
		textField_13.setColumns(8);

		JLabel lblNewLabel_12 = new JLabel("Package");
		lblNewLabel_12.setFont(new Font("Verdana", Font.PLAIN, 30));
		panel_4.add(lblNewLabel_12);

		textField_14 = new JTextField();
		textField_14.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(textField_14);
		textField_14.setColumns(8);

		JLabel lblNewLabel_13 = new JLabel("Pre Conditions");
		lblNewLabel_13.setFont(new Font("Verdana", Font.PLAIN, 30));
		panel_4.add(lblNewLabel_13);

		textField_15 = new JTextField();
		textField_15.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(textField_15);
		textField_15.setColumns(25);

		JLabel lblNewLabel_14 = new JLabel("Post Conditions");
		lblNewLabel_14.setFont(new Font("Verdana", Font.PLAIN, 30));
		panel_4.add(lblNewLabel_14);

		textField_16 = new JTextField();
		textField_16.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(textField_16);
		textField_16.setColumns(25);

		JLabel lblNewLabel_15 = new JLabel("Last Verdict");
		lblNewLabel_15.setFont(new Font("Verdana", Font.PLAIN, 30));
		panel_4.add(lblNewLabel_15);

		textField_17 = new JTextField();
		textField_17.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(textField_17);
		textField_17.setColumns(16);

		JLabel lblNewLabel_16 = new JLabel("Last Build");
		lblNewLabel_16.setFont(new Font("Verdana", Font.PLAIN, 30));
		panel_4.add(lblNewLabel_16);

		textField_18 = new JTextField();
		textField_18.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(textField_18);
		textField_18.setColumns(16);

		JLabel lblNewLabel_17 = new JLabel("Last Run");
		lblNewLabel_17.setFont(new Font("Verdana", Font.PLAIN, 30));
		panel_4.add(lblNewLabel_17);

		textField_19 = new JTextField();
		textField_19.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(textField_19);
		textField_19.setColumns(16);

		JFilePicker filePicker = new JFilePicker(Constants.test_script_path,
				"Browse...");
		filePicker.setBorder(new LineBorder(Color.DARK_GRAY, 2, true));
		filePicker.setMode(JFilePicker.MODE_OPEN);

		filePicker.addFileTypeFilter(".xls", "Xls Files");
		filePicker.addFileTypeFilter(".xlsx", "Xlsx Files");
		JFileChooser fileChooser = filePicker.getFileChooser();
		fileChooser.setCurrentDirectory(new File("C:/"));
		filePicker.setAlignmentX(SwingConstants.NORTH_WEST);
		panel_3.add(filePicker);

		JLabel lblNewLabel = new JLabel("\n" + Constants.welcome_message + "\n");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel);
		panel_1.setLayout(gl_panel_1);
		Font font = new Font("Verdana", Font.BOLD, 17);

		btnNewButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if (action.equals("Process test script")) {
			ProgressMonitoring progressMonitoring = new ProgressMonitoring();
			progressMonitoring.execute();
			btnNewButton.setEnabled(true);
		}
	}
}
