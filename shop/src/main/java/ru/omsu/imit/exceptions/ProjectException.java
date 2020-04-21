package ru.omsu.imit.exceptions;

import ru.omsu.imit.utils.ProjectErrorCode;

public class ProjectException extends Exception {

	private static final long serialVersionUID = 6049904777923589329L;
	private ProjectErrorCode errorCode;
	private String param;

	public ProjectException(ProjectErrorCode errorCode, String param) {
		this.errorCode = errorCode;
		this.param = param;
	}

	public ProjectException(ProjectErrorCode errorCode) {
		this(errorCode, null);
	}

	public ProjectErrorCode getErrorCode() {
		return errorCode;
	}

	public String getMessage() {
		if (param != null)
			return String.format(errorCode.getMessage(), param);
		else
			return errorCode.getMessage();
	}

}
