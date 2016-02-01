package com.autodesk.rallyuploader.utils;

import java.util.ArrayList;
import java.util.List;

import com.autodesk.rallyuploader.exeption.RallyUploaderException;

public interface ReadExcelData {
	public ArrayList<Integer> getAllTestsceneriosId(String filename)
			throws RallyUploaderException;

	public List<String> getAllcelldata(String filename)
			throws RallyUploaderException;

	public String mergeCelldata(int start_index, int end_index, String filename)
			throws RallyUploaderException;

}
