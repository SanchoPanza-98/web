package ru.omsu.imit.dto.response;

import ru.omsu.imit.utils.ProjectErrorCode;

public class FailureResponse {

	private ProjectErrorCode errorCode;
	private String message;

	public FailureResponse(ProjectErrorCode errorCode, String message) {
		super();
		this.errorCode = errorCode;
		this.message = message;
	}

	public FailureResponse(ProjectErrorCode errorCode) {
		this(errorCode, "");
	}
	public ProjectErrorCode getErrorCode() {
		return errorCode;
	}


	public String getMessage() {
		return message;
	}


}
