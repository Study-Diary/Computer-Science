package com.seikim.webcore;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.seikim.exception.CustomException;

@RestControllerAdvice
public class CustomControllerAdvice {
	@ExceptionHandler({CustomException.class})
	public ResponseEntity<String> customException(CustomException e) {
		return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
	}

	@ExceptionHandler({RuntimeException.class})
	public ResponseEntity<String> exception(RuntimeException e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("알 수 없는 서버의 오류입니다.");
	}
}
