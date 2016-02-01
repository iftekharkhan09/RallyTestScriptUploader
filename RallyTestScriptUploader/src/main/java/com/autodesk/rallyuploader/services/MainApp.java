package com.autodesk.rallyuploader.services;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.autodesk.rallyuploader.entity.ExcelData;
import com.autodesk.rallyuploader.exeption.RallyUploaderException;
import com.autodesk.rallyuploader.utils.Constants;
import com.autodesk.rallyuploader.utils.ReadExcelData;
import com.autodesk.rallyuploader.utils.ResultStatusConstants;
import com.autodesk.rallyuploader.utils.UploaderUtility;
import com.autodesk.rallyuploader.utils.WriteExcelData;

public class MainApp {
	public static void main(String[] args) throws RallyUploaderException,
			IOException, InterruptedException {
		MainApp mainApp = new MainApp();
		SwingFileChooserDemo swingFileChooserDemo=new SwingFileChooserDemo();
		swingFileChooserDemo.main(null);
		
	}
	public void execute(String filename)
			throws RallyUploaderException, IOException {

		File file = new File(filename);
		ReadExcelData readExcelDataImpl = new ReadExcelDataImpl();
		WriteExcelData writeExcelData = new WriteExcelDataImpl();
		Map<ExcelData, Object> final_map = new HashMap<ExcelData, Object>();
		if (file.exists()) {
			System.out.println(Constants.file_processing);
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
		// String mod_file = in.next();
		//writeExcelData.writeFormatteddatatoExcel(final_map, outputfile);
	}

}