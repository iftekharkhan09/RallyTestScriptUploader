package com.autodesk.rallyuploader.utils;

public enum ResultStatusConstants {
	SUCCESS(0), NON_INCREASING_TEST_SCENERIO_ID(1001), ERROR_CLOSING_FILE(1002), FILE_NOT_FOUND_ERROR(
			1003), ERROR_READING_FILE(1004), CELL_DATA_LIMIT_EXCEEDED(1005), DATA_TO_LARGE_TO_MANAGE(
			1006);
	private int statusCode;

	private ResultStatusConstants(final int resultStatusCode) {
		this.statusCode = resultStatusCode;
	}

	public int getCode() {
		return statusCode;
	}
}
