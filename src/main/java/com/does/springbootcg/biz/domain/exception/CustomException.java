package com.does.springbootcg.biz.domain.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomException extends Exception {

	private Constants.ExceptionClass exceptionClass;
	private HttpStatus httpStatus;

	public CustomException(Constants.ExceptionClass exceptionClass, HttpStatus httpStatus, String message) {
		super(message);
		this.exceptionClass = exceptionClass;
		this.httpStatus = httpStatus;
	}

	public int getHttpStatusCode() {
		return httpStatus.value();
	}

	public String getHttpStatusType() {
		return httpStatus.getReasonPhrase();
	}
}
