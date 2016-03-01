package com.autodesk.rallyuploader.services;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import com.autodesk.rallyuploader.utils.FileUtility;

public class MonitoringLogProcesser {
	private final String DEFAULT_CONVERSATION_PATTERN = "%d{yyyy-MM-dd HH:mm:ss} [%-4p] [%t] %c:%L - %m%n";
	private final String DEFAULT_LOG_FILE_PATH = "src/main/resources/log4j.properties";
	private final String MONITORING_FILE_KEY = "monitoringFile";
	private final String LEVEL_KEY = "LEVEL";
	FileAppender fileAppender;
	FileUtility fileUtility;

	public void setLog4jProperties() {
		fileUtility = new FileUtility();
		String monitoringfile = fileUtility.getPropertiesValue(
				MONITORING_FILE_KEY, DEFAULT_LOG_FILE_PATH);
		final String LoggingLevel = fileUtility.getPropertiesValue(LEVEL_KEY,
				DEFAULT_LOG_FILE_PATH);
		PatternLayout layout = new PatternLayout();
		String conversionPattern = DEFAULT_CONVERSATION_PATTERN;
		layout.setConversionPattern(conversionPattern);
		fileAppender = new FileAppender();
		fileAppender.setFile(monitoringfile);
		fileAppender.setLayout(layout);
		fileAppender.activateOptions();
		Logger rootLogger = Logger.getRootLogger();
		if (LoggingLevel.equalsIgnoreCase("ALL"))
			rootLogger.setLevel(Level.ALL);
		else if (LoggingLevel.equalsIgnoreCase("DEBUG"))
			rootLogger.setLevel(Level.DEBUG);
		else if (LoggingLevel.equalsIgnoreCase("WARN"))
			rootLogger.setLevel(Level.WARN);
		else if (LoggingLevel.equalsIgnoreCase("INFO"))
			rootLogger.setLevel(Level.INFO);
		else if (LoggingLevel.equalsIgnoreCase("ERROR"))
			rootLogger.setLevel(Level.ERROR);
		else
			rootLogger.setLevel(Level.FATAL);
		rootLogger.addAppender(fileAppender);
	}
}
