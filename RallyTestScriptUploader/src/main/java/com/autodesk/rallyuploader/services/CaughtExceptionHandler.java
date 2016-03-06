package com.autodesk.rallyuploader.services;
import java.awt.EventQueue;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Component;
 public class CaughtExceptionHandler {
	public CaughtExceptionHandler() {
		super();
	}

	private static JDialog frame;
	private String exception_data;
	private static int no_of_objects_created=0;
	
	public String getException_data() {
		return exception_data;
	}
	public void setException_data(String exception_data) {
		this.exception_data = exception_data;
	}
	
	public static void main(String exception) {
		final String exception_message = exception;
		setNo_of_objects_created(getNo_of_objects_created() + 1);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CaughtExceptionHandler window = new CaughtExceptionHandler(
							exception_message);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private CaughtExceptionHandler(String exception_data) {
		this.exception_data = exception_data;
		initialize(exception_data);
	}

	private void initialize(String data) {
		String exception_message = data;
		frame = new JDialog();
		frame.setTitle("Exception Details");
		frame.setBounds(100, 100, 450, 150);
		frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 428, 0 };
		gridBagLayout.rowHeights = new int[] { 256, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		GridBagConstraints gbc_splitPane = new GridBagConstraints();
		gbc_splitPane.fill = GridBagConstraints.BOTH;
		gbc_splitPane.gridx = 0;
		gbc_splitPane.gridy = 0;
		frame.getContentPane().add(splitPane, gbc_splitPane);

		JLabel lblNewLabel = new JLabel("Exception : Stack Trace");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		splitPane.setLeftComponent(lblNewLabel);
		JTextArea jTextArea = new JTextArea(exception_message);
		jTextArea.setEditable(false);
		jTextArea.setFont(new Font("Vrinda", Font.PLAIN, 14));
		jTextArea.setWrapStyleWord(true);
		jTextArea.setLineWrap(true);
		splitPane.setRightComponent(jTextArea);
		jTextArea.setAlignmentX(Component.LEFT_ALIGNMENT);
	}
	public static int getNo_of_objects_created() {
		return no_of_objects_created;
	}
	public static void setNo_of_objects_created(int no_of_objects_created) {
		CaughtExceptionHandler.no_of_objects_created = no_of_objects_created;
	}

}
