package com.autodesk.rallyuploader.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.autodesk.rallyuploader.services.ExceptionHandler;

public class FileUtility {
	static Logger logger = Logger
			.getLogger(com.autodesk.rallyuploader.utils.FileUtility.class);
	private BufferedReader bufferedReader;

	public String convertFileDataToString(String file) throws IOException {
		bufferedReader = new BufferedReader(new FileReader(file));
		String line = null;
		StringBuilder stringBuilder = new StringBuilder();
		String ls = System.getProperty("line.separator");
		while ((line = bufferedReader.readLine()) != null) {
			stringBuilder.append(line);
			stringBuilder.append(ls);
		}
		return stringBuilder.toString();
	}

	public String getPropertiesValue(String key, String filename) throws URISyntaxException {
		try {
			/*URL resource = ClassLoader.getSystemResource(filename);
			File file = new File(resource.toURI());
			FileInputStream fileInput = new FileInputStream(file);*/
			//FileInputStream fileInput = new FileInputStream(in);
			InputStream in=ClassLoader.getSystemResourceAsStream(filename);
			
			
			Properties properties = new Properties();
			properties.load(in);
			String value = properties.getProperty(key);
			in.close();
			return value;
		} catch (FileNotFoundException e) {
			logger.error("Unable to locate the properties file - " + e);
			ExceptionHandler.main(e.toString());
		} catch (IOException e) {
			logger.error("Error while reading the properties file - " + e);
			ExceptionHandler.main(e.toString());
		}
		return null;
	}
}
