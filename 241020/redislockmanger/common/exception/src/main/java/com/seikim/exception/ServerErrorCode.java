package com.seikim.exception;

public interface ServerErrorCode {
	int getStatusCode();

	String getErrorCode();

	String getMessage();
}
