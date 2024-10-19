package com.seikim.exception;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {
	private final int statusCode;
	private final String errorCode;
	private final String message;

	public CustomException(ServerErrorCode serverErrorCode) {
		this.statusCode = serverErrorCode.getStatusCode();
		this.errorCode = serverErrorCode.getErrorCode();
		this.message = serverErrorCode.getMessage();
	}
}
