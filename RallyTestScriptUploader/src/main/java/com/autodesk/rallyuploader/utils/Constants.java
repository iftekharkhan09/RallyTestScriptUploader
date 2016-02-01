package com.autodesk.rallyuploader.utils;

public interface Constants {
	final String sheetname = "TestSheet";
	final String testscenerio_identifier = "_TS";
	final String space = "\\s";
	final String break_line = "</br></br>";
	final String below_line = "</br>---------------------------------------------------------</br>";
	final String testscenerioderror = "The test scenerio ids are not properly numbered.Please verify!!";
	final String fileclosingerror = "Error while trying to close the file!!";
	final String empty_cell = "is empty";
	final String testvalidationno = "Test Validation ID - ";
	final String testcaseno = "Test Case ID - ";
	final String author = "ahmed.khan.iftekhar@autodesk.com";
	final String input_file_not_found = "Input file cannot be found";
	final String output_file_exists = "Output file already exists";
	final String error_reading_file = "Not able to read the excel sheet";
	final String non_decreasing_id = "The test scenerio IDs are not in non-incresing order.Please verify!!";
	final String sucess = "Test data successfully written to the file - ";
	final String welcome_message = "Welcome to the test script uploader to rally utility!!";
	final String developer_identity = "This application has been developed by ";
	final String test_script_path = "Please select the input test script";
	final String final_test_script_path = "Please enter the full path of the output test script";
	final String file_processing = "Processing the cells in the excel sheet....";
	final String unable_to_create_file = "Unable to create the output file in the path specified";
	final String cell_limit_exceeded = "The Length Of the below Cell is more than what is supported by .xls,.xlsx and csv files.Please break the Test Scenerio.";
	final String unable_to_write_data = "Unable to write the data to the output file!!";
}
