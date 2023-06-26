package com.does.springbootcg.biz.service;

import com.does.springbootcg.biz.dto.SignInResultDto;
import com.does.springbootcg.biz.dto.SignUpResultDto;

public interface SignService {

	SignUpResultDto signUp(String id, String password, String name, String role);
	SignInResultDto signIn(String id, String password) throws RuntimeException;
}
