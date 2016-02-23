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

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.omg.PortableInterceptor.INACTIVE;

import com.autodesk.rallyuploader.exeption.RallyUploaderException;
import com.autodesk.rallyuploader.services.ReadExcelDataImpl;

public class UploaderUtility {
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

	public static boolean isArraynondecresing(List<Integer> arrayList)
			throws RallyUploaderException {
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

		for (int i = 1; i < list1.size(); i++) {
			list1.set(i, list1.get(i - 1) + list1.get(i));
		}
		return list1;
	}

	public static int getNoofcolumns(String filename) {
		FileInputStream fis = null;
		int noofcolumns = 0;
		try {
			fis = new FileInputStream(new File(filename));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		XSSFWorkbook myWorkBook = null;
		try {
			myWorkBook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
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

			e.printStackTrace();
		}
		XSSFWorkbook myWorkBook = null;
		try {
			myWorkBook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
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

	public List<Integer> getStartIndex(String filename)
			throws RallyUploaderException {
		List<Integer> alltestsceneriosid_list = new ArrayList<Integer>();
		readExcelData = new ReadExcelDataImpl();
		try {
			alltestsceneriosid_list = readExcelData
					.getAllTestsceneriosId(filename);
		} catch (RallyUploaderException e1) {
			throw new RallyUploaderException(
					ResultStatusConstants.ERROR_READING_FILE,
					Constants.error_reading_file);
		}

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
	public List<Integer> getEndIndex(String filename)
			throws RallyUploaderException {
		UploaderUtility uploaderUtility = new UploaderUtility();
		List<Integer> start_index_list = new ArrayList<Integer>();
		start_index_list = getStartIndex(filename);
		List<Integer> end_index = new ArrayList<Integer>();
		ReadExcelDataImpl readExcelDataImpl=new ReadExcelDataImpl();
		int total_no_of_cells=readExcelDataImpl.getAllcelldata(filename).size();
		for (int i = 0; i < start_index_list.size(); i++) {
			if (i == start_index_list.size() - 1) {
				end_index.add(total_no_of_cells - 1);
			} else {
				end_index.add((start_index_list.get(i + 1)) - 1);
			}
		}
		return end_index;

	}

	public static List<Integer> getTestIdfrequency(List<Integer> list)
			throws RallyUploaderException {
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
		} catch (Exception e) {
			throw new RallyUploaderException(
					ResultStatusConstants.NON_INCREASING_TEST_SCENERIO_ID,
					Constants.non_decreasing_id);
		}
	}

	public static int getTotalnoofcellls(String filename) {
		full_path_of_input_file = filename;
		return getNoofcolumns(full_path_of_input_file)
				* getNoofRows(full_path_of_input_file);
	}
}
