package com.autodesk.rallyuploader.utils;

import java.io.IOException;
import java.util.Map;

import com.autodesk.rallyuploader.entity.ExcelData;
import com.autodesk.rallyuploader.exeption.RallyUploaderException;

public interface WriteExcelData {
	public void writeFormatteddatatoExcel(Map<ExcelData, Object> map,
			String FILE_PATH) throws RallyUploaderException, IOException;

}
