package com.open.rallyuploader.exeption;

import com.open.rallyuploader.utils.ResultStatusConstants;

public class RallyUploaderException extends Exception {
	private static final long serialVersionUID = 1L;
	private ResultStatusConstants errorCode;

	public RallyUploaderException(final ResultStatusConstants code,
			final String message) {
		super(message);
		this.errorCode = code;
	}

	public RallyUploaderException(final ResultStatusConstants code,
			final String message, final Throwable cause) {
		super(message, cause);
		this.errorCode = code;
	}

	public ResultStatusConstants getErrorCode() {
		return errorCode;
	}
}
