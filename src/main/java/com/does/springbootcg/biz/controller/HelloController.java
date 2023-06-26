package com.does.springbootcg.biz.controller;

import com.does.springbootcg.biz.dto.MemberDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class HelloController {

	 private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/hello")
	public String hello(MemberDto memberDto) {
		return memberDto.toString();
	}

	@PostMapping("/member1")
	public String member1(@RequestBody Map<String, String> params) {
		LOGGER.info("params : {}", params);
		StringBuilder sb = new StringBuilder();
		params.forEach((key, value) -> sb.append(key + " : " + value + "\n"));
		return sb.toString();
	}

	@PostMapping("/member2")
	public ResponseEntity<MemberDto> post(@RequestBody MemberDto memberDto) {
		return ResponseEntity
				.status(HttpStatus.ACCEPTED)
				.body(memberDto);
	}

	@ApiOperation(value = "get 메서드 예제", notes = "@RequestParam을 활용한 get method")
	@GetMapping("/swagger")
	public String swaggerDesc(
			@ApiParam(value = "이름", required = true) @RequestParam String name,
			@ApiParam(value = "나이", required = true) @RequestParam String age) {

		return "이름 : " + name + ", 나이 : " + age;
	}
}
