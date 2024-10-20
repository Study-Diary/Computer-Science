package com.seikim.mysqldomain.exception;

import com.seikim.exception.CustomException;

public class JpaException extends CustomException {
	public JpaException(JpaErrorCode errorCode) {
		super(errorCode);
	}
}
