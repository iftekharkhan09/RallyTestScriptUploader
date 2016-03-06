package com.autodesk.rallyuploader.services;
import java.awt.EventQueue;
import javax.swing.JOptionPane;
public class ExceptionHandler {
	public ExceptionHandler() {
		super();
	}

	private static JOptionPane frame;
	private String exception_data;
	private static int no_of_objects_created = 0;

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
					ExceptionHandler window = new ExceptionHandler(
							exception_message);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private ExceptionHandler(String exception_data) {
		this.exception_data = exception_data;
		initialize(exception_data);
	}

	private void initialize(String data) {
		String exception_message = data;
		int input = JOptionPane.showOptionDialog(null, exception_message,
				"Exception:Stack Trace", JOptionPane.CANCEL_OPTION,
				JOptionPane.INFORMATION_MESSAGE, null, null, null);

		if (input == JOptionPane.OK_OPTION||input==JOptionPane.CANCEL_OPTION) {
			System.exit(1);
		}
	}

	public static int getNo_of_objects_created() {
		return no_of_objects_created;
	}

	public static void setNo_of_objects_created(int no_of_objects_created) {
		ExceptionHandler.no_of_objects_created = no_of_objects_created;
	}

}
