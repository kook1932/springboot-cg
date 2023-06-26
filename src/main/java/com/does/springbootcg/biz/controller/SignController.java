package com.does.springbootcg.biz.controller;

import com.does.springbootcg.biz.dto.SignInResultDto;
import com.does.springbootcg.biz.dto.SignUpResultDto;
import com.does.springbootcg.biz.service.SignService;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/sign-api")
@RestController
public class SignController {

	private final SignService signService;

	@PostMapping("/sign-in")
	public SignInResultDto signIn(@ApiParam(value = "ID", required = true) @RequestParam String id,
	                              @ApiParam(value = "Password", required = true) @RequestParam String password) {

		log.info("[signIn] 로그인을 시도하고 있습니다. id : {}, pw : ****", id);
		SignInResultDto signInResultDto = signService.signIn(id, password);

		if (signInResultDto.getCode() == 0) {
			log.info("[signIn] 정상적으로 로그인되었습니다. id : {}, token : {}", id, signInResultDto.getToken());
		}
		return signInResultDto;
	}

	@PostMapping("/sign-up")
	public SignUpResultDto signUp(@ApiParam(value = "ID", required = true) @RequestParam String id,
	                              @ApiParam(value = "비밀번호", required = true) @RequestParam String password,
	                              @ApiParam(value = "이름", required = true) @RequestParam String name,
	                              @ApiParam(value = "권한", required = true) @RequestParam String role) {

		log.info("[signUp] 회원가입을 수행합니다. id : {}, pw : ****, name : {}, role : {}", id, name, role);
		SignUpResultDto signUpResultDto = signService.signUp(id, password, name, role);

		log.info("[signUp] 회원가입을 완료했습니다. id : {}", id);
		return signUpResultDto;
	}

	@GetMapping("/exception")
	public void exceptionTest() throws RuntimeException {
		throw new RuntimeException("접근이 금지되었습니다.");
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Map<String, String>> exceptionHandler(RuntimeException e) {
		HttpHeaders responseHeaders = new HttpHeaders();
		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

		log.info("ExceptionHandler 호출, {}, {}", e.getCause(), e.getMessage());

		Map<String, String> map = new HashMap<>();
		map.put("error type", httpStatus.getReasonPhrase());
		map.put("code", "400");
		map.put("message", "에러 발생");

		return new ResponseEntity<>(map, responseHeaders, httpStatus);
	}
}
