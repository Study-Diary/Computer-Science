package com.seikim.mysqldomain.exception;

import com.seikim.exception.ServerErrorCode;

import lombok.Getter;

@Getter
public enum JpaErrorCode implements ServerErrorCode {
	ALREADY_DELETED_ENTITY(400, "JPA_001", "복구 중 문제가 발생하였습니다."),
	NO_DELETED_ENTITY(400, "JPA_002", "삭제 중 문제가 발생하였습니다."),
	;

	private final int statusCode;
	private final String errorCode;
	private final String message;

	JpaErrorCode(int statusCode, String errorCode, String message) {
		this.statusCode = statusCode;
		this.errorCode = errorCode;
		this.message = message;
	}
}
