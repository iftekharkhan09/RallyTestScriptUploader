package com.autodesk.rallyuploader.utils;

public enum ResultStatusConstants {
	SUCCESS(0),
	UNSUPPORTED_CELL_DATA(1000),
	NON_INCREASING_TEST_SCENERIO_ID(1001), 
	ERROR_CLOSING_FILE(1002),
	FILE_NOT_FOUND_ERROR(1003),
	ERROR_READING_FILE(1004),
	FILE_EXISTS(1005),
	CELL_LIMIT_EXCEEDED(1006),
	DATA_TO_LARGE_TO_MANAGE(1007);
	private int statusCode;
	private ResultStatusConstants(final int resultStatusCode) {
		this.statusCode = resultStatusCode;
	}
	public int getCode() {
		return statusCode;
	}
}
