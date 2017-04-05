package com.open.rallyuploader.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.open.rallyuploader.entity.ExcelData;
import com.open.rallyuploader.exeption.*;
import com.open.rallyuploader.utils.*;

public class ReadExcelDataImpl implements ReadExcelData {
	static Logger logger = Logger
			.getLogger(com.open.rallyuploader.services.ReadExcelDataImpl.class);

	public int getCellHeaderColumn(String filename, String column_value) {
		FileInputStream fis = null;
		int numberOfColumn = UploaderUtility.getNoofcolumns(filename);
		int i = 0;
		int j = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		try {
			fis = new FileInputStream(new File(filename));
			XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);
			XSSFSheet sheet = myWorkBook.getSheetAt(0);
			Row row = null;
			Cell cell = null;
			XSSFRow header_row = sheet.getRow(0);
			for (i = 0; i < numberOfColumn; i++) {
				XSSFCell header_cell = header_row.getCell(i);
				String header = header_cell.getStringCellValue();
				if (header.equalsIgnoreCase(column_value)) {
					j = i + 1;
					return j;
				}
			}
		} catch (IOException ex) {

			ExceptionHandler.main(ex.toString());
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				try {
					throw new RallyUploaderException(
							ResultStatusConstants.ERROR_CLOSING_FILE,
							Constants.fileclosing_error);
				} catch (RallyUploaderException e1) {
					logger.error(e1);
					ExceptionHandler.main(e1.toString());
				}
			}
		}
		return j;
	}

	public ArrayList<Integer> getAllTestsceneriosId(String filename) {
		FileInputStream fis = null;
		int numberOfColumn = UploaderUtility.getNoofcolumns(filename);
		ArrayList<Integer> list = new ArrayList<Integer>();

		ReadExcelDataImpl readExcelDataImpl = new ReadExcelDataImpl();
		int column_no = readExcelDataImpl.getCellHeaderColumn(filename,
				Constants.test_scenerio_condition);
		if (column_no == 0) {
			logger.error(Constants.test_scenario_Id_column_not_found);
			ExceptionHandler.main(Constants.test_scenario_Id_column_not_found);
		} else {
			try {
				column_no = column_no - 1;
				fis = new FileInputStream(new File(filename));
				XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);
				XSSFSheet sheet = myWorkBook.getSheetAt(0);
				Row row = null;
				Cell cell = null;
				numberOfColumn = UploaderUtility.getNoofcolumns(filename);
				Iterator rows = sheet.iterator();

				while (rows.hasNext()) {
					row = (Row) rows.next();
					if (row.getRowNum() == 0 || row == null) {
						continue;
					}
					String key = null;
					for (int colIndex = 0; colIndex < numberOfColumn; colIndex++) {
						if (colIndex == column_no) {
							cell = row.getCell(colIndex);
							if (cell.getStringCellValue() != null) {
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

			} catch (IOException ex) {
				logger.error(ex);
				ExceptionHandler.main(ex.toString());
			} finally {
				try {
					fis.close();
				} catch (IOException e) {
					try {
						throw new RallyUploaderException(
								ResultStatusConstants.ERROR_CLOSING_FILE,
								Constants.fileclosing_error);
					} catch (RallyUploaderException e1) {
						logger.error(e1);
						ExceptionHandler.main(e1.toString());
					}
				}
			}
			return list;
		}
		return null;
	}

	public List<String> getAllcelldata(String filename) {
		int test_condition_column_no = getCellHeaderColumn(filename,
				Constants.test_condition_id);

		int test_steps_column_no = getCellHeaderColumn(filename,
				Constants.Test_Steps);

		int test_step_expected_result_column_no = getCellHeaderColumn(filename,
				Constants.Test_Step_Expected_Result);

		if (test_condition_column_no == 0) {
			logger.error(Constants.test_condition_id_column_not_found);
			ExceptionHandler.main(Constants.test_condition_id_column_not_found);
		} else
			test_condition_column_no = test_condition_column_no - 1;

		if (test_steps_column_no == 0) {
			logger.error(Constants.test_Steps_column_not_found);
			ExceptionHandler.main(Constants.test_Steps_column_not_found);
		} else
			test_steps_column_no = test_steps_column_no - 1;
		if (test_step_expected_result_column_no == 0) {
			logger.error(Constants.test_step_expected_result_coumn_not_found);
			ExceptionHandler.main(Constants.test_step_expected_result_coumn_not_found);
		}

		List<Integer> alltestsceneriosid_list = new ArrayList<Integer>();
		alltestsceneriosid_list = getAllTestsceneriosId(filename);
		Set<Integer> nonduplicatedsceneriodid_list = new HashSet<Integer>();
		nonduplicatedsceneriodid_list = UploaderUtility
				.getNonduplicatedId(alltestsceneriosid_list);
		List<Integer> testidfrequency_list = new ArrayList<Integer>();
		testidfrequency_list = UploaderUtility
				.getTestIdfrequency(alltestsceneriosid_list);
		List<Integer> aggregatedlist = new ArrayList<Integer>();
		aggregatedlist = UploaderUtility
				.getAggregatedarray(testidfrequency_list);
		FileInputStream fis = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			fis = new FileInputStream(new File(filename));
		} catch (FileNotFoundException e) {
			try {
				throw new RallyUploaderException(
						ResultStatusConstants.FILE_NOT_FOUND_ERROR,
						Constants.input_file_not_found);
			} catch (RallyUploaderException e1) {
				logger.error(e1);
				CaughtExceptionHandler.main(e1.toString());
			}
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

			for (int l = 3; l < 5; l++) {
				int counter1 = 1;
				for (int i = counter1; i < no_of_rows; i++) {
					String header = new String();
					String cell_concatvalue = new String();
					String header_builder = new String();
					Row r = sheet.getRow(i);
					Cell c = r.getCell(l, Row.RETURN_BLANK_AS_NULL);
					Cell header_cell = r.getCell(test_condition_column_no,
							Row.CREATE_NULL_AS_BLANK);
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
			try {
				throw new RallyUploaderException(
						ResultStatusConstants.ERROR_READING_FILE,
						Constants.error_reading_file);
			} catch (RallyUploaderException e1) {
				logger.error(e1);
				ExceptionHandler.main(e1.toString());
			}
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				try {
					throw new RallyUploaderException(
							ResultStatusConstants.ERROR_CLOSING_FILE,
							Constants.fileclosing_error);
				} catch (RallyUploaderException e1) {
					logger.error(e1);
					ExceptionHandler.main(e1.toString());
				}
			}
		}
		return null;

	}

	public String mergeCelldata(int start_index, int end_index, String filename) {
		List<String> list = new ArrayList<String>();
		list = getAllcelldata(filename);
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

	public Map<ExcelData, Object> saveExceldata(String filename) {
		File file = new File(filename);
		ReadExcelData readExcelDataImpl = new ReadExcelDataImpl();
		Map<ExcelData, Object> final_map = new HashMap<ExcelData, Object>();
		if (file.exists()) {
			List<Integer> alltestsceneriosid_list = new ArrayList<Integer>();
			alltestsceneriosid_list = readExcelDataImpl
					.getAllTestsceneriosId(filename);
			Set<Integer> nonduplicatedsceneriodid_list = new HashSet<Integer>();
			nonduplicatedsceneriodid_list = UploaderUtility
					.getNonduplicatedId(alltestsceneriosid_list);
			List<Integer> testidfrequency_list = new ArrayList<Integer>();
			testidfrequency_list = UploaderUtility
					.getTestIdfrequency(alltestsceneriosid_list);
			List<Integer> list1 = new ArrayList<Integer>();
			list1 = testidfrequency_list;
			List<Integer> aggregatedlist = new ArrayList<Integer>();
			aggregatedlist = UploaderUtility
					.getAggregatedarray(testidfrequency_list);
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
			int row = 1;
			int col = 17;
			ExcelData excelData = new ExcelData();
			excelData.setColumnno(col);
			excelData.setRowno(row);
			final_map.put(excelData, final_array.get(0));
			for (int i = 1; i < final_array.size(); i++) {
				if (((i) % aggregatedlist.size()) == 0) {
					col++;
					row = 1;
				} else
					row++;
				ExcelData excelData2 = new ExcelData();
				excelData2.setRowno(row);
				excelData2.setColumnno(col);
				final_map.put(excelData2, final_array.get(i));
			}
		} else
			try {
				throw new RallyUploaderException(
						ResultStatusConstants.FILE_NOT_FOUND_ERROR,
						Constants.input_file_not_found);
			} catch (RallyUploaderException e) {
				logger.error(e);
				CaughtExceptionHandler.main(e.toString());
			}
		return final_map;
	}

	public Map<Integer, String> saveAlltestSceneiosdata(String filename) {
		ReadExcelDataImpl readExcelDataImpl = new ReadExcelDataImpl();
		List<Integer> alltestsceneriosid_list = new ArrayList<Integer>();
		alltestsceneriosid_list = readExcelDataImpl
				.getAllTestsceneriosId(filename);
		Set<Integer> nonduplicatedsceneriodid_list = new LinkedHashSet<Integer>();
		nonduplicatedsceneriodid_list = UploaderUtility
				.getNonduplicatedId(alltestsceneriosid_list);
		List<Integer> testidfrequency_list = new ArrayList<Integer>();
		testidfrequency_list = UploaderUtility
				.getTestIdfrequency(alltestsceneriosid_list);
		List<Integer> list1 = new ArrayList<Integer>();
		list1 = testidfrequency_list;
		List<Integer> aggregatedlist = new ArrayList<Integer>();
		aggregatedlist = UploaderUtility
				.getAggregatedarray(testidfrequency_list);
		List<Integer> agg_list = new ArrayList<Integer>();
		agg_list.add(0, 1);
		for (int i = 0; i < aggregatedlist.size() - 1; i++) {
			agg_list.add(aggregatedlist.get(i) + 2);
		}
		List<Integer> nonduplicatesceneriosid_list = new ArrayList<Integer>();
		Iterator<Integer> it = nonduplicatedsceneriodid_list.iterator();
		while (it.hasNext()) {
			nonduplicatesceneriosid_list.add(it.next());
		}

		FileInputStream fis = null;
		int numberOfColumn = UploaderUtility.getNoofcolumns(filename);
		Set<String> set = new LinkedHashSet<String>();
		int column_no = readExcelDataImpl.getCellHeaderColumn(filename,
				Constants.Test_Scenario);

		if (column_no == 0) {
			logger.error(Constants.test_scenario_column_not_found);
			ExceptionHandler.main(Constants.test_scenario_column_not_found);
		} else
			column_no = column_no - 1;
		try {
			fis = new FileInputStream(new File(filename));
			XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);
			XSSFSheet sheet = myWorkBook.getSheetAt(0);
			Row row = null;
			Cell cell = null;
			numberOfColumn = UploaderUtility.getNoofcolumns(filename);
			Iterator rows = sheet.iterator();

			while (rows.hasNext()) {
				row = (Row) rows.next();
				if (row.getRowNum() == 0 || row == null) {
					continue;
				}
				String key = null;
				for (int colIndex = 0; colIndex < numberOfColumn; colIndex++) {
					if (colIndex == column_no) {
						cell = row.getCell(colIndex);
						if (cell != null) {
							key = cell.getStringCellValue();
							set.add(key);
						}
					}
				}
			}
		} catch (IOException ex) {
			logger.error(ex);
			ExceptionHandler.main(ex.toString());
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				try {
					throw new RallyUploaderException(
							ResultStatusConstants.ERROR_CLOSING_FILE,
							Constants.fileclosing_error);
				} catch (RallyUploaderException e1) {
					logger.error(e1);
					ExceptionHandler.main(e1.toString());
				}
			}
		}

		List<String> set_values = new ArrayList<String>();
		Iterator<String> itt = set.iterator();
		while (itt.hasNext()) {
			set_values.add(itt.next());
		}
		Map<Integer, String> map = new LinkedHashMap<Integer, String>();

		if (nonduplicatedsceneriodid_list.size() > set_values.size()) {
			try {
				throw new RallyUploaderException(
						ResultStatusConstants.DUPLICATE_TEST_SCENERIO,
						Constants.duplicate_scenerio);
			} catch (RallyUploaderException e) {
				logger.error(e);
				ExceptionHandler.main(e.toString());
			}
		}
		if (nonduplicatedsceneriodid_list.size() < set_values.size()) {
			try {
				throw new RallyUploaderException(
						ResultStatusConstants.DUPLICATE_TEST_SCENERIO,
						Constants.duplicate_scenerios_exceeds);
			} catch (RallyUploaderException e) {
				logger.error(e);
				ExceptionHandler.main(e.toString());
			}
		}
		for (int i = 0; i < nonduplicatedsceneriodid_list.size(); i++) {
			map.put(nonduplicatesceneriosid_list.get(i), set_values.get(i));

		}
		return map;
	}

}