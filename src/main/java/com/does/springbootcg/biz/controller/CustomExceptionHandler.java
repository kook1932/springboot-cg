package com.does.springbootcg.biz.controller;

import com.does.springbootcg.biz.domain.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Map<String, String>> handleException(RuntimeException e, HttpServletRequest request) {
		HttpHeaders responseHeaders = new HttpHeaders();
		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

		log.error("RuntimeException 발생, {}, {}", request.getRequestURI(), e.getMessage());

		HashMap<String, String> map = new HashMap<>();
		map.put("error type", httpStatus.getReasonPhrase());
		map.put("code", "400");
		map.put("message", e.getMessage());

		return new ResponseEntity<>(map, responseHeaders, httpStatus);
	}

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<Map<String, String>> handleException(CustomException e, HttpServletRequest request) {
		HttpHeaders responseHeaders = new HttpHeaders();
		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

		log.error("RuntimeException 발생, {}, {}", request.getRequestURI(), e.getMessage());

		HashMap<String, String> map = new HashMap<>();
		map.put("error type", e.getHttpStatusType());
		map.put("code", Integer.toString(e.getHttpStatusCode()));
		map.put("message", e.getMessage());

		return new ResponseEntity<>(map, responseHeaders, httpStatus);
	}
}
