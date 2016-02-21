package com.autodesk.rallyuploader.services;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.autodesk.rallyuploader.entity.ExcelData;
import com.autodesk.rallyuploader.exeption.RallyUploaderException;
import com.autodesk.rallyuploader.utils.Constants;
import com.autodesk.rallyuploader.utils.ResultStatusConstants;
import com.autodesk.rallyuploader.utils.WriteExcelData;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class WriteExcelDataImpl implements WriteExcelData {
	public void writeFormatteddatatoExcel(Map<ExcelData, Object> map,
			String FILE_PATH) throws RallyUploaderException, IOException {

		for (Map.Entry<ExcelData, Object> entry : map.entrySet()) {
			System.out.println("Key = " + entry.getKey().getRowno() + " "
					+ entry.getKey().getColumnno() + ", Value = "
					+ entry.getValue().toString());
		}

		Workbook workbook = new XSSFWorkbook();
		File file = new File(FILE_PATH);
		Row row = null;
		FileOutputStream fos = null;
		Sheet sheet = workbook.createSheet(Constants.sheet_name_output_script);
		Iterator it = map.entrySet().iterator();
		try {
			while (it.hasNext()) {
				Map.Entry pair = (Map.Entry) it.next();
				ExcelData excelData = new ExcelData();
				excelData = (ExcelData) pair.getKey();
				int rowno = excelData.getRowno();
				int columnno = excelData.getColumnno();
				String value = (String) pair.getValue().toString();
				row = sheet.getRow(rowno);
				if (row == null) {
					row = sheet.createRow(rowno);
				}
				Cell c = row.getCell(columnno);
				if (c == null) {
					c = row.createCell(columnno, Cell.CELL_TYPE_STRING);
				}
				Row row1 = sheet.getRow(rowno);
				if (value.length() >= 32767) {
					System.out.println(Constants.cell_limit_exceeded);
					System.out.println("cell address - " + excelData.getRowno()
							+ " " + excelData.getColumnno());

				} else
					c.setCellValue(value);
			}
			fos = new FileOutputStream(FILE_PATH);
			workbook.write(fos);
		}

		finally {
			try {
				fos.close();
			} catch (IOException e) {
				throw new RallyUploaderException(
						ResultStatusConstants.ERROR_CLOSING_FILE,
						Constants.fileclosing_error);
			}
		}
		System.out.println(Constants.success + FILE_PATH);
	}
}
