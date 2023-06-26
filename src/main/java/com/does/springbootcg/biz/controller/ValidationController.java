package com.does.springbootcg.biz.controller;

import com.does.springbootcg.biz.domain.group.ValidationGroup1;
import com.does.springbootcg.biz.domain.group.ValidationGroup2;
import com.does.springbootcg.biz.dto.ValidRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RequestMapping("/validation")
@RestController
public class ValidationController {

	@PostMapping("/valid")
	public ResponseEntity<String> checkValidationByValid(@Validated @RequestBody ValidRequestDto validRequestDto) {
		log.info(validRequestDto.toString());
		return ResponseEntity.status(HttpStatus.OK).body(validRequestDto.toString());
	}

	@PostMapping("/valid/group1")
	public ResponseEntity<String> checkValidationByValid1(@Validated(ValidationGroup1.class) @RequestBody ValidRequestDto validRequestDto) {
		log.info(validRequestDto.toString());
		return ResponseEntity.status(HttpStatus.OK).body(validRequestDto.toString());
	}

	@PostMapping("/valid/group2")
	public ResponseEntity<String> checkValidationByValid2(@Validated(ValidationGroup2.class) @RequestBody ValidRequestDto validRequestDto) {
		log.info(validRequestDto.toString());
		return ResponseEntity.status(HttpStatus.OK).body(validRequestDto.toString());
	}
}
