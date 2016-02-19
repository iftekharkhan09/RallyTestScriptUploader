package com.autodesk.rallyuploader.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.autodesk.rallyuploader.entity.ExcelData;
import com.autodesk.rallyuploader.exeption.*;
import com.autodesk.rallyuploader.utils.*;

public class ReadExcelDataImpl implements ReadExcelData {

	private List<Integer> alltestsceneriosid_list;
	private List<Integer> testidfrequency_list;
	private List<Integer> aggregatedlist;
	private Set<Integer> nonduplicatedsceneriodid_list;

	public Set<Integer> getNonduplicatedsceneriodid_list() {
		return nonduplicatedsceneriodid_list;
	}

	public void setNonduplicatedsceneriodid_list(
			Set<Integer> nonduplicatedsceneriodid_list) {
		this.nonduplicatedsceneriodid_list = nonduplicatedsceneriodid_list;
	}

	public List<Integer> getAlltestsceneriosid_list() {
		return alltestsceneriosid_list;
	}

	public void setAlltestsceneriosid_list(List<Integer> alltestsceneriosid_list) {
		this.alltestsceneriosid_list = alltestsceneriosid_list;
	}

	public List<Integer> getTestidfrequency_list() {
		return testidfrequency_list;
	}

	public void setTestidfrequency_list(List<Integer> testidfrequency_list) {
		this.testidfrequency_list = testidfrequency_list;
	}

	public List<Integer> getAggregatedlist() {
		return aggregatedlist;
	}

	public void setAggregatedlist(List<Integer> aggregatedlist) {
		this.aggregatedlist = aggregatedlist;
	}

	public ArrayList<Integer> getAllTestsceneriosId(String filename)
			throws RallyUploaderException {
		FileInputStream fis = null;
		int numberOfColumn = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		try {
			fis = new FileInputStream(new File(filename));
			XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);
			XSSFSheet sheet = myWorkBook.getSheetAt(0);
			Row row = null;
			Cell cell = null;
			Iterator rowIterator = sheet.rowIterator();
			numberOfColumn = UploaderUtility.getNoofcolumns(filename);
			Iterator rows = sheet.iterator();
			while (rows.hasNext()) {
				row = (Row) rows.next();
				if (row != null) {
					String key = null;
					for (int colIndex = 0; colIndex < numberOfColumn; colIndex++) {
						if (colIndex == 0) {
							cell = row.getCell(colIndex);
							if (cell != null) {
								key = cell.getStringCellValue();
								int index = key
										.indexOf(Constants.testscenerio_identifier);
								String testscenerio = key.substring(index + 3,
										key.length());
								String id = testscenerio.replaceAll(
										Constants.space, "");
								int testscenerioid = Integer.parseInt(id);
								list.add(testscenerioid);
							}
						}
					}
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				throw new RallyUploaderException(
						ResultStatusConstants.ERROR_CLOSING_FILE,
						Constants.fileclosing_error);
			}
		}
		return list;
	}

	public List<String> getAllcelldata(String filename)
			throws RallyUploaderException {
		List<Integer> alltestsceneriosid_list = new ArrayList<Integer>();
		try {
			alltestsceneriosid_list = getAllTestsceneriosId(filename);
		} catch (RallyUploaderException e1) {
			throw new RallyUploaderException(
					ResultStatusConstants.ERROR_READING_FILE,
					Constants.error_reading_file);
		}
		setAlltestsceneriosid_list(alltestsceneriosid_list);
		Set<Integer> nonduplicatedsceneriodid_list = new HashSet<Integer>();
		nonduplicatedsceneriodid_list = UploaderUtility
				.getNonduplicatedId(alltestsceneriosid_list);

		setNonduplicatedsceneriodid_list(nonduplicatedsceneriodid_list);
		List<Integer> testidfrequency_list = new ArrayList<Integer>();
		testidfrequency_list = UploaderUtility
				.getTestIdfrequency(alltestsceneriosid_list);
		List<Integer> aggregatedlist = new ArrayList<Integer>();
		aggregatedlist = UploaderUtility
				.getAggregatedarray(testidfrequency_list);
		setAggregatedlist(aggregatedlist);
		FileInputStream fis = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			fis = new FileInputStream(new File(filename));
		} catch (FileNotFoundException e) {
			throw new RallyUploaderException(
					ResultStatusConstants.FILE_NOT_FOUND_ERROR,
					Constants.input_file_not_found);
		}
		XSSFWorkbook myWorkBook = null;
		try {
			myWorkBook = new XSSFWorkbook(fis);
			XSSFSheet sheet = myWorkBook.getSheetAt(0);
			Iterator rows = sheet.iterator();
			Row row = null;
			List<String> array = new ArrayList<String>();
			int no_of_columns = UploaderUtility.getNoofcolumns(filename);
			int no_of_rows = UploaderUtility.getNoofRows(filename);
			for (int l = 2; l < no_of_columns; l++) {
				int counter1 = 0;
				for (int i = counter1; i < no_of_rows; i++) {
					String header = new String();
					String cell_concatvalue = new String();
					String header_builder = new String();
					Row r = sheet.getRow(i);
					Cell c = r.getCell(l, Row.RETURN_BLANK_AS_NULL);
					Cell header_cell = r.getCell(1, Row.CREATE_NULL_AS_BLANK);
					String cell_value = c.getStringCellValue();
					header = header_cell.getStringCellValue();
					header_builder = header.concat(Constants.below_line);
					cell_concatvalue = header_builder.concat(cell_value
							.concat(Constants.break_line));
					array.add(cell_concatvalue);
					counter1++;
				}
			}
			return array;
		} catch (IOException e) {
			throw new RallyUploaderException(
					ResultStatusConstants.ERROR_READING_FILE,
					Constants.error_reading_file);
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				throw new RallyUploaderException(
						ResultStatusConstants.ERROR_CLOSING_FILE,
						Constants.fileclosing_error);
			}
		}

	}

	public String mergeCelldata(int start_index, int end_index, String filename)
			throws RallyUploaderException {
		List<String> list = new ArrayList<String>();
		try {
			list = getAllcelldata(filename);
		} catch (RallyUploaderException e) {
			throw new RallyUploaderException(
					ResultStatusConstants.ERROR_READING_FILE,
					Constants.error_reading_file);
		}
		String string = new String();
		List<String> list2 = new ArrayList<String>();
		for (int i = start_index; i <= end_index; i++)
			list2.add(list.get(i));
		for (int i = 0; i < list2.size(); i++) {
			string = string.concat(list2.get(i));
		}
		String final_String = string.replaceAll("\n", "</br>");
		return final_String;
	}

	public void saveExceldata(String filename) throws RallyUploaderException,
			IOException {
		File file = new File(filename);
		ReadExcelData readExcelDataImpl = new ReadExcelDataImpl();
		WriteExcelData writeExcelData = new WriteExcelDataImpl();
		Map<ExcelData, Object> final_map = new HashMap<ExcelData, Object>();
		if (file.exists()) {
			System.out.println(Constants.file_processing);
			alltestsceneriosid_list = new ArrayList<Integer>();
			
			
			alltestsceneriosid_list = getAggregatedlist();
			

			Iterator<Integer> it=alltestsceneriosid_list.iterator();
			while(it.hasNext())
			{
				System.out.println(it.next());
			}
			
			Set<Integer> nonduplicatedsceneriodid_list = new HashSet<Integer>();
			nonduplicatedsceneriodid_list = getNonduplicatedsceneriodid_list();
			testidfrequency_list = new ArrayList<Integer>();
			testidfrequency_list = getTestidfrequency_list();
			List<Integer> list1 = new ArrayList<Integer>();
			list1 = testidfrequency_list;
			aggregatedlist = new ArrayList<Integer>();
			aggregatedlist = getAggregatedlist();

			int no_of_rows = UploaderUtility.getNoofRows(filename);
			int no_of_columns = UploaderUtility.getNoofcolumns(filename) - 2;
			List<Integer> start_index_data = new ArrayList<Integer>();
			List<Integer> end_index_data = new ArrayList<Integer>();

			UploaderUtility uploaderUtility = new UploaderUtility();
			start_index_data = uploaderUtility.getStartIndex(filename);
			end_index_data = uploaderUtility.getEndIndex(filename);
			List<String> final_array = new ArrayList<String>();

			for (int i = 0; i < start_index_data.size(); i++) {

				String arr = new String();
				arr = readExcelDataImpl.mergeCelldata(start_index_data.get(i),
						end_index_data.get(i), filename);
				final_array.add(arr);
			}
			int row = 0;
			int col = 1;
			ExcelData excelData = new ExcelData();
			excelData.setColumnno(col);
			excelData.setRowno(row);
			final_map.put(excelData, final_array.get(0));
			for (int i = 1; i < final_array.size(); i++) {
				if (((i) % aggregatedlist.size()) == 0) {
					col++;
					row = 0;
				} else
					row++;
				ExcelData excelData2 = new ExcelData();
				excelData2.setRowno(row);
				excelData2.setColumnno(col);
				final_map.put(excelData2, final_array.get(i));
			}
			int fixed_row = 0;
			for (int z : nonduplicatedsceneriodid_list) {
				ExcelData excelData3 = new ExcelData();
				excelData3.setRowno(fixed_row);
				excelData3.setColumnno(0);
				final_map.put(excelData3, z);
				fixed_row++;
			}

		} else
			throw new RallyUploaderException(
					ResultStatusConstants.FILE_NOT_FOUND_ERROR,
					Constants.input_file_not_found);
		System.out.println(Constants.final_test_script_path);
	}
}