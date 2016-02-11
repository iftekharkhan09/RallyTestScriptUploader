package com.autodesk.rallyuploader.services;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.SwingConstants;

import java.awt.Insets;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFileChooser;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.autodesk.rallyuploader.entity.ExcelData;
import com.autodesk.rallyuploader.exeption.RallyUploaderException;
import com.autodesk.rallyuploader.utils.Constants;
import com.sun.corba.se.impl.activation.ProcessMonitorThread;

import javax.swing.border.CompoundBorder;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.DropMode;

import java.awt.TextField;
import java.awt.Button;

import javax.swing.JButton;

import java.awt.CardLayout;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;

import java.awt.Label;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SwingApplication {
	private static int static_column = 0;
	private JFrame frame;
	private JTextField display_color_textfield;
	private JTextField expedite_textfield;
	private JTextField ready_textfield;
	private JTextField last_result_textfield;
	private JTextField notes_textfield;
	private JTextField owner_textfield;
	private JTextField workproduct_textfield;
	private JTextField type_textfield;
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
	private String input_filepath;
	public JButton Process_test_script;
	private ArrayList<String> testScripts_array;
	private JFilePicker output_filepicker;
	private JFilePicker input_filepicker;
	private Map<ExcelData, Object> static_data = new HashMap<ExcelData, Object>();
	private JButton output_generator_button;

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

	public SwingApplication() {
		initialize();
	}

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

		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(Color.DARK_GRAY, 2, true));

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));

		output_generator_button = new JButton("Generate Output Script\r\n");
		JLabel lblNewLabel_19 = new JLabel("");

		JLabel lblNewLabel_20 = new JLabel("New label");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1
				.setHorizontalGroup(gl_panel_1
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_1.createSequentialGroup().addGap(39)
										.addComponent(lblNewLabel_19)
										.addContainerGap(991, Short.MAX_VALUE))
						.addGroup(
								gl_panel_1
										.createSequentialGroup()
										.addGap(19)
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_1
																		.createSequentialGroup()
																		.addGap(10)
																		.addComponent(
																				lblNewLabel_20))
														.addGroup(
																gl_panel_1
																		.createSequentialGroup()
																		.addGroup(
																				gl_panel_1
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								panel_6,
																								GroupLayout.DEFAULT_SIZE,
																								1001,
																								Short.MAX_VALUE)
																						.addComponent(
																								panel_7,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								panel_3,
																								GroupLayout.DEFAULT_SIZE,
																								1001,
																								Short.MAX_VALUE)
																						.addComponent(
																								panel_2,
																								GroupLayout.DEFAULT_SIZE,
																								1001,
																								Short.MAX_VALUE)
																						.addComponent(
																								panel_5,
																								GroupLayout.DEFAULT_SIZE,
																								1001,
																								Short.MAX_VALUE)
																						.addComponent(
																								panel_4,
																								Alignment.TRAILING,
																								GroupLayout.PREFERRED_SIZE,
																								1001,
																								Short.MAX_VALUE))
																		.addContainerGap())))
						.addGroup(
								Alignment.TRAILING,
								gl_panel_1.createSequentialGroup()
										.addContainerGap(457, Short.MAX_VALUE)
										.addComponent(output_generator_button)
										.addGap(428)));
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
						.addComponent(panel_5, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 277,
								GroupLayout.PREFERRED_SIZE)
						.addGap(1)
						.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 49,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 48,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(output_generator_button).addGap(11)
						.addComponent(lblNewLabel_19)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblNewLabel_20)
						.addContainerGap(71, Short.MAX_VALUE)));
		panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		output_filepicker = new JFilePicker(Constants.final_test_script_path,
				"Browse...");
		panel_6.add(output_filepicker);
		GridBagLayout gbl_panel_7 = new GridBagLayout();
		gbl_panel_7.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel_7.rowHeights = new int[] { 0, 0 };
		gbl_panel_7.columnWeights = new double[] { 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		gbl_panel_7.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel_7.setLayout(gbl_panel_7);

		Label label_1 = new Label("New label");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.gridwidth = 2;
		gbc_label_1.insets = new Insets(0, 0, 0, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 0;
		panel_7.add(label_1, gbc_label_1);

		JTextArea txtrItIsRecommended = new JTextArea();
		txtrItIsRecommended.setFont(new Font("Monospaced", Font.ITALIC, 15));
		txtrItIsRecommended.setLineWrap(true);
		txtrItIsRecommended
				.setText("It is recommended to enter the values in the above fields,if the values are same for most of the test scenerios.You can also create/modify the values in the output excel sheet. ");
		GridBagConstraints gbc_txtrItIsRecommended = new GridBagConstraints();
		gbc_txtrItIsRecommended.fill = GridBagConstraints.BOTH;
		gbc_txtrItIsRecommended.gridx = 2;
		gbc_txtrItIsRecommended.gridy = 0;
		panel_7.add(txtrItIsRecommended, gbc_txtrItIsRecommended);
		panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel_18 = new JLabel(
				"Click here to start the processing of the input sheet ");
		lblNewLabel_18.setFont(new Font("Verdana", Font.PLAIN, 25));
		lblNewLabel_18.setVerticalAlignment(SwingConstants.TOP);
		panel_5.add(lblNewLabel_18);

		Process_test_script = new JButton("Process test script");
		Process_test_script.setFont(new Font("Verdana", Font.PLAIN, 15));
		panel_5.add(Process_test_script);

		// Process_test_script.addActionListener(this);

		JLabel label = new JLabel("");
		panel_5.add(label);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel_1 = new JLabel("Display Color:");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 30));
		panel_4.add(lblNewLabel_1);

		display_color_textfield = new JTextField();
		display_color_textfield.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(display_color_textfield);
		display_color_textfield.setColumns(8);

		JLabel lblNewLabel_2 = new JLabel("Expedite:");
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 30));
		panel_4.add(lblNewLabel_2);

		expedite_textfield = new JTextField();
		expedite_textfield.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(expedite_textfield);
		expedite_textfield.setColumns(8);

		JLabel lblNewLabel_3 = new JLabel("Ready:");
		lblNewLabel_3.setFont(new Font("Verdana", Font.PLAIN, 30));
		panel_4.add(lblNewLabel_3);

		ready_textfield = new JTextField();
		ready_textfield.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(ready_textfield);
		ready_textfield.setColumns(8);

		JLabel lblNewLabel_4 = new JLabel("Last Result:");
		lblNewLabel_4.setFont(new Font("Verdana", Font.PLAIN, 30));
		panel_4.add(lblNewLabel_4);

		last_result_textfield = new JTextField();
		last_result_textfield.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(last_result_textfield);
		last_result_textfield.setColumns(8);

		JLabel lblNewLabel_6 = new JLabel("Owner:");
		lblNewLabel_6.setFont(new Font("Verdana", Font.PLAIN, 30));
		panel_4.add(lblNewLabel_6);

		notes_textfield = new JTextField();
		notes_textfield.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(notes_textfield);
		notes_textfield.setColumns(20);

		JLabel lblNewLabel_7 = new JLabel("User Story:");
		lblNewLabel_7.setFont(new Font("Verdana", Font.PLAIN, 30));
		panel_4.add(lblNewLabel_7);

		owner_textfield = new JTextField();
		owner_textfield.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(owner_textfield);
		owner_textfield.setColumns(8);

		JLabel lblNewLabel_5 = new JLabel("Notes:");
		lblNewLabel_5.setFont(new Font("Verdana", Font.PLAIN, 30));
		panel_4.add(lblNewLabel_5);

		workproduct_textfield = new JTextField();
		workproduct_textfield.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(workproduct_textfield);
		workproduct_textfield.setColumns(27);

		JLabel lblNewLabel_8 = new JLabel("Type:");
		lblNewLabel_8.setFont(new Font("Verdana", Font.PLAIN, 30));
		panel_4.add(lblNewLabel_8);

		workproduct_textfield = new JTextField();
		workproduct_textfield.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(workproduct_textfield);
		workproduct_textfield.setColumns(8);

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

		JLabel lblNewLabel_12 = new JLabel("Package:");
		lblNewLabel_12.setFont(new Font("Verdana", Font.PLAIN, 30));
		panel_4.add(lblNewLabel_12);

		textField_14 = new JTextField();
		textField_14.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(textField_14);
		textField_14.setColumns(8);

		JLabel lblNewLabel_13 = new JLabel("Pre Conditions:");
		lblNewLabel_13.setFont(new Font("Verdana", Font.PLAIN, 30));
		panel_4.add(lblNewLabel_13);

		textField_15 = new JTextField();
		textField_15.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(textField_15);
		textField_15.setColumns(25);

		JLabel lblNewLabel_14 = new JLabel("Post Conditions:");
		lblNewLabel_14.setFont(new Font("Verdana", Font.PLAIN, 30));
		panel_4.add(lblNewLabel_14);

		textField_16 = new JTextField();
		textField_16.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(textField_16);
		textField_16.setColumns(25);

		JLabel lblNewLabel_15 = new JLabel("Last Verdict:");
		lblNewLabel_15.setFont(new Font("Verdana", Font.PLAIN, 30));
		panel_4.add(lblNewLabel_15);

		textField_17 = new JTextField();
		textField_17.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(textField_17);
		textField_17.setColumns(16);

		JLabel lblNewLabel_16 = new JLabel("Last Build:");
		lblNewLabel_16.setFont(new Font("Verdana", Font.PLAIN, 30));
		panel_4.add(lblNewLabel_16);

		textField_18 = new JTextField();
		textField_18.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(textField_18);
		textField_18.setColumns(16);

		JLabel lblNewLabel_17 = new JLabel("Last Run:");
		lblNewLabel_17.setFont(new Font("Verdana", Font.PLAIN, 30));
		panel_4.add(lblNewLabel_17);

		textField_19 = new JTextField();
		textField_19.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(textField_19);
		textField_19.setColumns(16);

		input_filepicker = new JFilePicker(Constants.test_script_path,
				"Browse...");
		input_filepicker.setBorder(new LineBorder(Color.DARK_GRAY, 2, true));
		input_filepicker.setMode(JFilePicker.MODE_OPEN);

		input_filepicker.addFileTypeFilter(".xls", "Xls Files");
		input_filepicker.addFileTypeFilter(".xlsx", "Xlsx Files");
		final JFileChooser fileChooser = input_filepicker.getFileChooser();
		fileChooser.setCurrentDirectory(new File("C:/"));
		input_filepicker.setAlignmentX(SwingConstants.NORTH_WEST);
		panel_3.add(input_filepicker);

		JLabel lblNewLabel = new JLabel("\n" + Constants.welcome_message + "\n");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel);
		panel_1.setLayout(gl_panel_1);
		Font font = new Font("Verdana", Font.BOLD, 17);
		// System.out.println(filePicker2.getInput_file_path());

		Process_test_script.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(fileChooser.getSelectedFile()
						.getAbsolutePath());
				if (fileChooser.getSelectedFile().getAbsolutePath() != null) {
					String file_path=fileChooser.getSelectedFile().getAbsolutePath();
					ProgressMonitoring progressMonitoring = new ProgressMonitoring(
							file_path);
					progressMonitoring.main(file_path);
					Process_test_script.setEnabled(false);
				} else {
				}

			}
		});
		output_generator_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WriteExcelDataImpl writeExcelDataImpl = new WriteExcelDataImpl();
				String file = "C:\\finy.xlsx";
				try {
					ProcessStaticdata();
					writeExcelDataImpl.writeFormatteddatatoExcel(static_data,
							file);
				} catch (RallyUploaderException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

	}

	public void ProcessStaticdata() throws RallyUploaderException, IOException {
		testScripts_array = new ArrayList<String>();
		testScripts_array.add(display_color_textfield.getText());
		testScripts_array.add(expedite_textfield.getText());
		testScripts_array.add(ready_textfield.getText());
		testScripts_array.add(last_result_textfield.getText());
		testScripts_array.add("");
		testScripts_array.add("");
		testScripts_array.add(notes_textfield.getText());
		testScripts_array.add(owner_textfield.getText());
		testScripts_array.add(workproduct_textfield.getText());
		testScripts_array.add("");
		writexceldata();

	}

	public void writexceldata() throws RallyUploaderException, IOException {
		for (int i = 0; i < testScripts_array.size(); i++) {
			String data = testScripts_array.get(i);
			for (int j = 1; j < 14; j++) {
				ExcelData excelData = new ExcelData();
				excelData.setRowno(j);
				excelData.setColumnno(static_column);
				static_data.put(excelData, data);
			}
			static_column++;
		}

	}

}