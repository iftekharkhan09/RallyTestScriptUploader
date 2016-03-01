package com.autodesk.rallyuploader.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.autodesk.rallyuploader.exeption.RallyUploaderException;
import com.autodesk.rallyuploader.services.ExceptionHandler;
import com.autodesk.rallyuploader.services.ReadExcelDataImpl;

public class UploaderUtility {
	static Logger logger = Logger
			.getLogger(com.autodesk.rallyuploader.utils.UploaderUtility.class);
	private ReadExcelData readExcelData;
	private static String full_path_of_input_file;

	public static int getCountmathes(String data, String match) {
		int count = 0;
		for (int j = 0; j < data.length(); j++) {
			if (data.contains(match)) {
				count += 1;
			}
		}
		return count;
	}

	public static boolean isArraynondecresing(List<Integer> arrayList) {
		for (int i = 0; i < arrayList.size() - 1; i++) {
			if (arrayList.get(i) > arrayList.get(i + 1)) {
				return false;
			}
		}
		return true;
	}

	public static List<Integer> getAggregatedarray(List<Integer> list) {
		List<Integer> list1 = new ArrayList<Integer>();
		list1 = list;
		try {
			for (int i = 1; i < list1.size(); i++) {
				list1.set(i, list1.get(i - 1) + list1.get(i));
			}
		} catch (Exception exception) {
			logger.error(exception.getMessage());
		}
		return list1;
	}

	public static int getNoofcolumns(String filename) {
		FileInputStream fis = null;
		int noofcolumns = 0;
		try {
			fis = new FileInputStream(new File(filename));
		} catch (FileNotFoundException exception) {
			logger.error(exception);
			ExceptionHandler.main(Constants.input_file_not_found);
		}
		XSSFWorkbook myWorkBook = null;
		try {
			myWorkBook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			logger.error(e);
			ExceptionHandler.main(Constants.error_reading_file);
		}
		XSSFSheet sheet = myWorkBook.getSheetAt(0);
		Iterator rowIterator = sheet.rowIterator();
		if (rowIterator.hasNext()) {
			Row headerRow = (Row) rowIterator.next();
			noofcolumns = headerRow.getPhysicalNumberOfCells();
		}
		return noofcolumns;
	}

	public static int getNoofRows(String filename) {
		FileInputStream fis = null;
		int rowcount = 0;
		try {
			fis = new FileInputStream(new File(filename));
		} catch (FileNotFoundException e) {
			logger.error(e);
			ExceptionHandler.main(Constants.input_file_not_found);
		}
		XSSFWorkbook myWorkBook = null;
		try {
			myWorkBook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			logger.error(e);
			ExceptionHandler.main(Constants.error_reading_file);
		}
		XSSFSheet sheet = myWorkBook.getSheetAt(0);
		rowcount = sheet.getPhysicalNumberOfRows();
		return rowcount;
	}

	public static Set<Integer> getNonduplicatedId(List<Integer> list) {
		Set<Integer> set = new LinkedHashSet<Integer>();
		set.addAll(list);
		return set;
	}

	public List<Integer> getStartIndex(String filename) {
		List<Integer> alltestsceneriosid_list = new ArrayList<Integer>();
		readExcelData = new ReadExcelDataImpl();
		alltestsceneriosid_list = readExcelData.getAllTestsceneriosId(filename);
		Set<Integer> nonduplicatedsceneriodid_list = new LinkedHashSet<Integer>();
		nonduplicatedsceneriodid_list = UploaderUtility
				.getNonduplicatedId(alltestsceneriosid_list);
		List<Integer> testidfrequency_list = new ArrayList<Integer>();
		testidfrequency_list = UploaderUtility
				.getTestIdfrequency(alltestsceneriosid_list);
		List<Integer> aggregatedlist = new ArrayList<Integer>();
		aggregatedlist = UploaderUtility
				.getAggregatedarray(testidfrequency_list);
		List<Integer> start_index = new ArrayList<Integer>();
		start_index.add(0);
		int no_of_rows = getNoofRows(filename);
		for (int j : aggregatedlist) {
			start_index.add(j);
		}
		int limit = aggregatedlist.size();
		for (int x = 1; x < limit; x++) {
			start_index.add(start_index.get(x) + no_of_rows - 1);
		}
		return start_index;
	}

	public List<Integer> getEndIndex(String filename) {
		UploaderUtility uploaderUtility = new UploaderUtility();
		List<Integer> start_index_list = new ArrayList<Integer>();
		start_index_list = getStartIndex(filename);
		List<Integer> end_index = new ArrayList<Integer>();
		ReadExcelDataImpl readExcelDataImpl = new ReadExcelDataImpl();
		int total_no_of_cells = readExcelDataImpl.getAllcelldata(filename)
				.size();
		for (int i = 0; i < start_index_list.size(); i++) {
			if (i == start_index_list.size() - 1) {
				end_index.add(total_no_of_cells - 1);
			} else {
				end_index.add((start_index_list.get(i + 1)) - 1);
			}
		}
		return end_index;

	}

	public static List<Integer> getTestIdfrequency(List<Integer> list) {
		int counter = 0;
		Set<Integer> sortedset = new HashSet<Integer>();
		sortedset.addAll(list);
		List<Integer> Sortedlist = new ArrayList<Integer>();
		try {
			if (UploaderUtility.isArraynondecresing(list)) {
				for (int s : sortedset) {
					counter = Collections.frequency(list, s);
					Sortedlist.add(counter);
				}
				return Sortedlist;
			} else {
				throw new RallyUploaderException(
						ResultStatusConstants.NON_INCREASING_TEST_SCENERIO_ID,
						Constants.non_decreasing_id);
			}
		} catch (RallyUploaderException rallyUploaderException) {
			logger.error(rallyUploaderException);
			ExceptionHandler.main(rallyUploaderException.toString());
		} catch (Exception exception) {
			logger.error(exception);
			ExceptionHandler.main(exception.toString());
		}
		return null;
	}

	public static int getTotalnoofcellls(String filename) {
		full_path_of_input_file = filename;
		return getNoofcolumns(full_path_of_input_file)
				* getNoofRows(full_path_of_input_file);
	}
}
