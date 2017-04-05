package com.open.rallyuploader.utils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.open.rallyuploader.entity.ExcelData;

public interface ReadExcelData {
	public ArrayList<Integer> getAllTestsceneriosId(String filename);

	public List<String> getAllcelldata(String filename);

	public String mergeCelldata(int start_index, int end_index, String filename);

	public int getCellHeaderColumn(String filename, String column_value);

	public Map<ExcelData, Object> saveExceldata(String filename);

	public Map<Integer, String> saveAlltestSceneiosdata(String filename);

}
