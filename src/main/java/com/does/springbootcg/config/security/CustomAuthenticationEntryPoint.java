package com.does.springbootcg.config.security;

import com.does.springbootcg.biz.dto.EntryPointErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
		ObjectMapper mapper = new ObjectMapper();
		log.info("[commence] 인증 실패로 response.sendError 발생");

		EntryPointErrorResponse entryPointErrorResponse = new EntryPointErrorResponse();
		entryPointErrorResponse.setMsg("인증이 실패하였습니다.");

		response.setStatus(401);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(mapper.writeValueAsString(entryPointErrorResponse));
	}
}
