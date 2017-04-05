package com.open.rallyuploader.services;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import org.apache.log4j.Logger;
import com.open.rallyuploader.entity.ExcelData;
import com.open.rallyuploader.exeption.RallyUploaderException;
import com.open.rallyuploader.utils.Constants;
import com.open.rallyuploader.utils.ResultStatusConstants;
import com.open.rallyuploader.utils.UploaderUtility;
public class SwingApplication extends ReadExcelDataImpl {
	private static int static_column = 0;
	private JFrame frame;
	private JTextField display_color_textfield;
	private JTextField expedite_textfield;
	private JTextField ready_textfield;
	private JTextField last_result_textfield;
	private JTextField owner_textfield;
	private JTextField userstory_textfield;
	private JTextField type_textfield;
	private JTextField notes_textfield;
	private JTextField method_textField;
	private JTextField priority_textfield;
	private JTextField risk_textfield;
	private JTextField package_textfield;
	private JTextField precondition_textfield;
	private JTextField postcondition_textfield;
	private JTextField lastverdict_textfield;
	private JTextField last_build_textfield;
	private JTextField last_run_textfield;
	public JButton Process_test_script;
	private ArrayList<String> testScripts_array;
	private JFilePicker output_filepicker;
	private JFilePicker input_filepicker;
	private Map<ExcelData, Object> static_data = new HashMap<ExcelData, Object>();
	private JButton output_generator_button;
	private JFileChooser filechooser_outputpath;
	private JFileChooser fileChooser_Inputpath;
	private static List<String> excelheaderlist;
	private String input_file_path;
	private MonitoringLogProcesser monitoringLogProcesser;
	static Logger logger = Logger
			.getLogger(com.open.rallyuploader.services.SwingApplication.class);

	public void call() {
		main(null);
	}

	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingApplication window = new SwingApplication();
					window.frame.setVisible(true);
				} catch (Exception e) {
					logger.error(e);
					e.printStackTrace();
				}
			}
		});
	}

	public SwingApplication() throws URISyntaxException {
		initialize();
	}

	private void initialize() throws URISyntaxException {
		monitoringLogProcesser = new MonitoringLogProcesser();
		monitoringLogProcesser.setLog4jProperties();
		frame = new JFrame();
		frame.setBounds(100, 100, 915, 736);
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

		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1
				.setHorizontalGroup(gl_panel_1
						.createParallelGroup(Alignment.TRAILING)
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
										.addContainerGap())
						.addGroup(
								gl_panel_1
										.createSequentialGroup()
										.addGap(457)
										.addComponent(output_generator_button,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE).addGap(428)));
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
						.addContainerGap(45, Short.MAX_VALUE)));
		panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		output_filepicker = new JFilePicker(Constants.final_test_script_path,
				"Browse...");
		output_filepicker.setMode(JFilePicker.MODE_OPEN);
		output_filepicker.addFileTypeFilter();
		filechooser_outputpath = output_filepicker.getFileChooser();
		// filechooser_outputpath.setCurrentDirectory(new File("C:/"));
		filechooser_outputpath.setAlignmentX(SwingConstants.CENTER);
		filechooser_outputpath.setAlignmentY(SwingConstants.CENTER);
		output_filepicker.setAlignmentX(SwingConstants.CENTER);

		panel_6.add(output_filepicker);
		GridBagLayout gbl_panel_7 = new GridBagLayout();
		gbl_panel_7.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel_7.rowHeights = new int[] { 0, 0 };
		gbl_panel_7.columnWeights = new double[] { 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		gbl_panel_7.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel_7.setLayout(gbl_panel_7);

		// Label Alert_Label = new Label("New label");
		BufferedImage myPicture = null;
		try {
			/*myPicture = ImageIO
					.read(new File("src/main/resources/download.png"));*/
			myPicture = ImageIO
					.read(ClassLoader.getSystemResource("download.png"));
		} catch (IOException e2) {
			logger.error(e2);
		}
		JLabel Alert_Label = new JLabel(new ImageIcon(myPicture));
		Alert_Label.setForeground(new Color(0, 0, 0));
		GridBagConstraints gbc_Alert_Label = new GridBagConstraints();
		gbc_Alert_Label.gridwidth = 2;
		gbc_Alert_Label.insets = new Insets(0, 0, 0, 5);
		gbc_Alert_Label.gridx = 0;
		gbc_Alert_Label.gridy = 0;
		panel_7.add(Alert_Label, gbc_Alert_Label);
		JTextArea txtrItIsRecommended = new JTextArea();
		txtrItIsRecommended.setFont(new Font("Monospaced", Font.ITALIC, 15));
		txtrItIsRecommended.setLineWrap(true);
		txtrItIsRecommended.setText(Constants.recommendation);
		GridBagConstraints gbc_txtrItIsRecommended = new GridBagConstraints();
		gbc_txtrItIsRecommended.fill = GridBagConstraints.BOTH;
		gbc_txtrItIsRecommended.gridx = 2;
		gbc_txtrItIsRecommended.gridy = 0;
		panel_7.add(txtrItIsRecommended, gbc_txtrItIsRecommended);
		panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JLabel lblNewLabel_18 = new JLabel(Constants.sheet_processing);
		lblNewLabel_18.setFont(new Font("Verdana", Font.PLAIN, 25));
		lblNewLabel_18.setVerticalAlignment(SwingConstants.TOP);
		panel_5.add(lblNewLabel_18);
		Process_test_script = new JButton("Process test script");
		Process_test_script.setFont(new Font("Verdana", Font.PLAIN, 15));
		panel_5.add(Process_test_script);
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

		owner_textfield = new JTextField();
		owner_textfield.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(owner_textfield);
		owner_textfield.setColumns(20);

		JLabel lblNewLabel_7 = new JLabel("User Story:");
		lblNewLabel_7.setFont(new Font("Verdana", Font.PLAIN, 30));
		panel_4.add(lblNewLabel_7);

		userstory_textfield = new JTextField();
		userstory_textfield.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(userstory_textfield);
		userstory_textfield.setColumns(8);

		JLabel lblNewLabel_5 = new JLabel("Notes:");
		lblNewLabel_5.setFont(new Font("Verdana", Font.PLAIN, 30));
		panel_4.add(lblNewLabel_5);

		notes_textfield = new JTextField();
		notes_textfield.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(notes_textfield);
		notes_textfield.setColumns(27);

		JLabel lblNewLabel_8 = new JLabel("Type:");
		lblNewLabel_8.setFont(new Font("Verdana", Font.PLAIN, 30));
		panel_4.add(lblNewLabel_8);

		type_textfield = new JTextField();
		type_textfield.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(type_textfield);
		type_textfield.setColumns(8);

		JLabel lblNewLabel_9 = new JLabel("Method:");
		lblNewLabel_9.setFont(new Font("Verdana", Font.PLAIN, 30));
		panel_4.add(lblNewLabel_9);

		method_textField = new JTextField();
		method_textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(method_textField);
		method_textField.setColumns(8);

		JLabel lblNewLabel_11 = new JLabel("Priority:");
		lblNewLabel_11.setFont(new Font("Verdana", Font.PLAIN, 30));
		panel_4.add(lblNewLabel_11);

		priority_textfield = new JTextField();
		priority_textfield.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(priority_textfield);
		priority_textfield.setColumns(8);

		JLabel lblNewLabel_10 = new JLabel("Risk:");
		lblNewLabel_10.setFont(new Font("Verdana", Font.PLAIN, 30));
		panel_4.add(lblNewLabel_10);

		risk_textfield = new JTextField();
		risk_textfield.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(risk_textfield);
		risk_textfield.setColumns(8);

		JLabel lblNewLabel_12 = new JLabel("Package:");
		lblNewLabel_12.setFont(new Font("Verdana", Font.PLAIN, 30));
		panel_4.add(lblNewLabel_12);

		package_textfield = new JTextField();
		package_textfield.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(package_textfield);
		package_textfield.setColumns(8);

		JLabel lblNewLabel_13 = new JLabel("Pre Conditions:");
		lblNewLabel_13.setFont(new Font("Verdana", Font.PLAIN, 30));
		panel_4.add(lblNewLabel_13);

		precondition_textfield = new JTextField();
		precondition_textfield.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(precondition_textfield);
		precondition_textfield.setColumns(25);

		JLabel lblNewLabel_14 = new JLabel("Post Conditions:");
		lblNewLabel_14.setFont(new Font("Verdana", Font.PLAIN, 30));
		panel_4.add(lblNewLabel_14);

		postcondition_textfield = new JTextField();
		postcondition_textfield.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(postcondition_textfield);
		postcondition_textfield.setColumns(25);

		JLabel lblNewLabel_15 = new JLabel("Last Verdict:");
		lblNewLabel_15.setFont(new Font("Verdana", Font.PLAIN, 30));
		panel_4.add(lblNewLabel_15);

		lastverdict_textfield = new JTextField();
		lastverdict_textfield.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(lastverdict_textfield);
		lastverdict_textfield.setColumns(16);

		JLabel lblNewLabel_16 = new JLabel("Last Build:");
		lblNewLabel_16.setFont(new Font("Verdana", Font.PLAIN, 30));
		panel_4.add(lblNewLabel_16);

		last_build_textfield = new JTextField();
		last_build_textfield.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(last_build_textfield);
		last_build_textfield.setColumns(16);

		JLabel lblNewLabel_17 = new JLabel("Last Run:");
		lblNewLabel_17.setFont(new Font("Verdana", Font.PLAIN, 30));
		panel_4.add(lblNewLabel_17);

		last_run_textfield = new JTextField();
		last_run_textfield.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(last_run_textfield);
		last_run_textfield.setColumns(16);

		input_filepicker = new JFilePicker(Constants.test_script_path,
				"Browse...");
		input_filepicker.setBorder(new LineBorder(Color.DARK_GRAY, 2, true));
		input_filepicker.setMode(JFilePicker.MODE_OPEN);

		input_filepicker.addFileTypeFilter();
		fileChooser_Inputpath = input_filepicker.getFileChooser();
		// fileChooser_Inputpath.setCurrentDirectory(new File("C:/"));
		fileChooser_Inputpath.setAlignmentX(SwingConstants.CENTER);
		fileChooser_Inputpath.setAlignmentY(SwingConstants.CENTER);
		input_filepicker.setAlignmentX(SwingConstants.CENTER);
		panel_3.add(input_filepicker);

		JLabel welcome_message = new JLabel("\n" + Constants.welcome_message
				+ "\n");
		welcome_message.setFont(new Font("Verdana", Font.BOLD, 30));
		welcome_message.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(welcome_message);
		panel_1.setLayout(gl_panel_1);

		Process_test_script.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Process test script")) {
					showProgressMonitor();
					ProcessExcelSheetData();
				}
			}
		});
		output_generator_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WriteExcelDataImpl writeExcelDataImpl = new WriteExcelDataImpl();
				String output_file_path = null;
				try {
					output_file_path = filechooser_outputpath.getSelectedFile()
							.getAbsolutePath();
				} catch (Exception e1) {
					try {
						throw new RallyUploaderException(
								ResultStatusConstants.FILE_NOT_FOUND_ERROR,
								Constants.output_file_not_present);
					} catch (RallyUploaderException e2) {
						logger.error(e2);
						CaughtExceptionHandler.main(e2.toString());
					}
				}
				try {
					input_file_path = fileChooser_Inputpath.getSelectedFile()
							.getAbsolutePath();
				} catch (Exception e1) {
					try {
						throw new RallyUploaderException(
								ResultStatusConstants.FILE_NOT_FOUND_ERROR,
								Constants.input_file_not_present);
					} catch (RallyUploaderException e2) {
						logger.error(e2);
						CaughtExceptionHandler.main(e2.toString());
					}
				}
				try {
					writeExcelHeader();
					ProcessStaticdata(input_file_path);
					writeExcelDataImpl.writeFormatteddatatoExcel(static_data,
							output_file_path);

				} catch (RallyUploaderException e1) {
					logger.error(e1);
					ExceptionHandler.main(e1.toString());
				} catch (IOException e1) {
					logger.error(e1);
					ExceptionHandler.main(e1.toString());
				}
			}
		});

	}
	public void showProgressMonitor() {
		try {
			input_file_path = fileChooser_Inputpath.getSelectedFile()
					.getAbsolutePath();
		} catch (Exception e) {
			try {
				throw new RallyUploaderException(
						ResultStatusConstants.FILE_NOT_FOUND_ERROR,
						Constants.input_file_not_present);
			} catch (RallyUploaderException ex) {
				logger.error(ex);
				CaughtExceptionHandler.main(ex.toString());
			}
		}
		Process_test_script.setEnabled(false);
		ProgressMonitoring.main(input_file_path);	
	}

	public void ProcessExcelSheetData() {
		ReadExcelDataImpl readExcelDataImpl = new ReadExcelDataImpl();
		Map<Integer, String> maps = new LinkedHashMap<Integer, String>();
		maps = readExcelDataImpl.saveAlltestSceneiosdata(input_file_path);
		try {
			decriptive(maps, input_file_path);
		} catch (RallyUploaderException e1) {
			logger.error(e1);
			ExceptionHandler.main(e1.toString());
		}
		try {
			Map<ExcelData, Object> data = new HashMap<ExcelData, Object>();
			data = readExcelDataImpl.saveExceldata(input_file_path);
			static_data.putAll(data);
		} catch (Exception ex) {
			logger.error(ex);
			ex.printStackTrace();
			ExceptionHandler.main(ex.toString());
		}
	}

	public void ProcessStaticdata(String filename)
			throws RallyUploaderException, IOException {
		testScripts_array = new ArrayList<String>();
		testScripts_array.add(display_color_textfield.getText());
		testScripts_array.add(expedite_textfield.getText());
		testScripts_array.add(ready_textfield.getText());
		testScripts_array.add(last_result_textfield.getText());
		testScripts_array.add("");
		testScripts_array.add("");
		testScripts_array.add(notes_textfield.getText());
		testScripts_array.add(owner_textfield.getText());
		testScripts_array.add(userstory_textfield.getText());
		testScripts_array.add("");
		testScripts_array.add(type_textfield.getText());// type
		testScripts_array.add(method_textField.getText());
		testScripts_array.add(priority_textfield.getText());
		testScripts_array.add(risk_textfield.getText());
		testScripts_array.add(package_textfield.getText());
		testScripts_array.add(precondition_textfield.getText());
		testScripts_array.add(postcondition_textfield.getText());
		testScripts_array.add("");
		testScripts_array.add("");
		testScripts_array.add(lastverdict_textfield.getText());
		testScripts_array.add(last_build_textfield.getText());
		testScripts_array.add(last_run_textfield.getText());
		writexceldata(filename);
	}

	public void excelHeaderProcessing() {
		excelheaderlist = new ArrayList<String>();
		excelheaderlist.add(Constants.display_color);
		excelheaderlist.add(Constants.expedite);
		excelheaderlist.add(Constants.ready);
		excelheaderlist.add(Constants.last_result);
		excelheaderlist.add(Constants.name);
		excelheaderlist.add(Constants.description);
		excelheaderlist.add(Constants.notes);
		excelheaderlist.add(Constants.owner);
		excelheaderlist.add(Constants.work_product);
		excelheaderlist.add(Constants.objective);
		excelheaderlist.add(Constants.type);
		excelheaderlist.add(Constants.method);
		excelheaderlist.add(Constants.priority);
		excelheaderlist.add(Constants.risk);
		excelheaderlist.add(Constants.packages);
		excelheaderlist.add(Constants.pre_conditions);
		excelheaderlist.add(Constants.post_conditions);
		excelheaderlist.add(Constants.validation_input);
		excelheaderlist.add(Constants.validation_expected_result);
		excelheaderlist.add(Constants.last_verdict);
		excelheaderlist.add(Constants.last_result);
		excelheaderlist.add(Constants.last_run);
	}

	public void writeExcelHeader() throws RallyUploaderException, IOException {
		int row = 0;
		excelHeaderProcessing();
		WriteExcelDataImpl writeExcelDataImpl = new WriteExcelDataImpl();
		for (int i = 0; i < excelheaderlist.size(); i++) {
			ExcelData excelData = new ExcelData();
			excelData.setRowno(row);
			excelData.setColumnno(i);
			String data = excelheaderlist.get(i);
			static_data.put(excelData, data);
		}
	}

	public void writexceldata(String filename) throws RallyUploaderException,
			IOException {
		ReadExcelDataImpl readExcelDataImpl = new ReadExcelDataImpl();
		List<Integer> alltestsceneriosid_list = new ArrayList<Integer>();
		alltestsceneriosid_list = readExcelDataImpl
				.getAllTestsceneriosId(filename);
		Set<Integer> nonduplicatedsceneriodid_list = new HashSet<Integer>();
		nonduplicatedsceneriodid_list = UploaderUtility
				.getNonduplicatedId(alltestsceneriosid_list);
		Iterator<Integer> it = nonduplicatedsceneriodid_list.iterator();
		for (int i = 0; i < testScripts_array.size(); i++) {
			String data = testScripts_array.get(i);
			if (data != "") {
				for (int j = 1; j <= nonduplicatedsceneriodid_list.size(); j++) {
					ExcelData excelData = new ExcelData();
					excelData.setRowno(j);
					excelData.setColumnno(static_column);
					static_data.put(excelData, data);
				}
			}
			static_column++;
		}
	}

	public void decriptive(Map<Integer, String> map, String filename)
			throws RallyUploaderException {
		Map<Integer, String> mapped_data = new LinkedHashMap<Integer, String>();
		mapped_data = map;
		// adding the name values
		int row_name = 1;
		int name_column = 4;
		for (Map.Entry<Integer, String> entry : mapped_data.entrySet()) {
			ExcelData excelData = new ExcelData();
			excelData.setRowno(row_name);
			excelData.setColumnno(name_column);
			String data = Constants.Test_Scenerio_sepator;
			String ext_data = data.concat(entry.getKey().toString());
			String extra_data = ext_data.concat("_");
			String final_data = extra_data.concat(entry.getValue());
			static_data.put(excelData, final_data);
			row_name++;
		}
		// adding the description values
		int row_description = 1;
		int description_column = 5;
		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			ExcelData excelData = new ExcelData();
			excelData.setRowno(row_description);
			excelData.setColumnno(description_column);
			static_data.put(excelData, entry.getValue());
			row_description++;
		}
		// adding the description values
		int objective_description = 1;
		int objective_column = 9;
		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			ExcelData excelData = new ExcelData();
			excelData.setRowno(objective_description);
			excelData.setColumnno(objective_column);
			static_data.put(excelData, entry.getValue());
			objective_description++;
		}
	}
	

}
