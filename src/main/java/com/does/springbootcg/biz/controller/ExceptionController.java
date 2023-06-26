package com.does.springbootcg.biz.controller;

import com.does.springbootcg.biz.domain.exception.Constants;
import com.does.springbootcg.biz.domain.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/exception")
@RestController
public class ExceptionController {

	@GetMapping
	public void getRuntimeException() {
		throw new RuntimeException("getRuntimeException 호출");
	}

	@GetMapping("/custom")
	public void getCustomException() throws CustomException {
		throw new CustomException(Constants.ExceptionClass.PRODUCT, HttpStatus.BAD_REQUEST, "CustomException 발생");
	}
}
