package com.open.rallyuploader.utils;
import java.util.Map;

import com.open.rallyuploader.entity.ExcelData;

public interface WriteExcelData {
	public void writeFormatteddatatoExcel(Map<ExcelData, Object> map,
			String FILE_PATH);

}
