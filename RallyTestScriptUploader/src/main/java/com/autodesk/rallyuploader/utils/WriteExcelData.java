package com.autodesk.rallyuploader.utils;
import java.util.Map;
import com.autodesk.rallyuploader.entity.ExcelData;

public interface WriteExcelData {
	public void writeFormatteddatatoExcel(Map<ExcelData, Object> map,
			String FILE_PATH);

}
