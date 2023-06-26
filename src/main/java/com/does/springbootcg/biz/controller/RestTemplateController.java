package com.does.springbootcg.biz.controller;

import com.does.springbootcg.biz.dto.MemberDto;
import com.does.springbootcg.biz.service.RestTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/rest-template")
@RestController
public class RestTemplateController {

	private final RestTemplateService restTemplateService;

	@GetMapping
	public String getName() {
		return restTemplateService.getName();
	}

	@GetMapping("/path-variable")
	public String getNameWithPathVariable() {
		return restTemplateService.getNameWithPathVariable();
	}

	@GetMapping("/parameter")
	public String getNameWithParameter() {
		return restTemplateService.getNameWithParameter();
	}

	@PostMapping
	public ResponseEntity<MemberDto> postDto() {
		return restTemplateService.postWithParamAndBody();
	}

	@PostMapping("/header")
	public ResponseEntity<MemberDto> postWithHeader() {
		return restTemplateService.postWithHeader();
	}
}
