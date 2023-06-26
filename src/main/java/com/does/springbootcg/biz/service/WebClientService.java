package com.does.springbootcg.biz.service;

import com.does.springbootcg.biz.dto.MemberDto;
import org.apache.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class WebClientService {

	public String getName() {
		WebClient webClient = WebClient.builder()
				.baseUrl("http://localhost:9090")
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.build();

		return webClient.get()
				.uri("/api/v1/crud-api")
				.retrieve()
				.bodyToMono(String.class)
				.block();
	}

	public String getNameWithPathVariable() {
		WebClient webClient = WebClient.create("http://localhost:9090");

		ResponseEntity<String> responseEntity = webClient.get()
				.uri(uriBuilder -> uriBuilder.path("/api/v1/crud-api/{name}").build("Does"))
				.retrieve()
				.toEntity(String.class)
				.block();

		return responseEntity.getBody();
	}

	public String getNameWithParameter() {
		WebClient webClient = WebClient.create("http://localhost:9090");

		return webClient
				.get()
				.uri(uriBuilder -> uriBuilder.path("/api/v1/crud-api")
						.queryParam("name", "Does")
						.build())
				.exchangeToMono(clientResponse -> {
					if (clientResponse.statusCode().equals(HttpStatus.OK)) {
						return clientResponse.bodyToMono(String.class);
					} else return clientResponse.createException().flatMap(Mono::error);
				})
				.block();
	}

	public ResponseEntity<MemberDto> postWithParamAndBody() {
		WebClient webClient = WebClient.builder()
				.baseUrl("http://localhost:9090")
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.build();

		MemberDto memberDto = new MemberDto();
		memberDto.setName("does");
		memberDto.setEmail("does@does.kr");
		memberDto.setOrganization("dodoes");

		return webClient
				.post()
				.uri(uriBuilder -> uriBuilder.path("/api/v1/crud-api")
						.queryParam("name", "does")
						.queryParam("email", "does@does.kr")
						.queryParam("organization", "dodoes")
						.build())
				.bodyValue(memberDto)
				.retrieve()
				.toEntity(MemberDto.class)
				.block();
	}

	public ResponseEntity<MemberDto> postWithHeader() {
		WebClient webClient = WebClient.builder()
				.baseUrl("http://localhost:9090")
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.build();

		MemberDto memberDto = new MemberDto();
		memberDto.setName("does");
		memberDto.setEmail("does@does.kr");
		memberDto.setOrganization("dodoes");

		return webClient
				.post()
				.uri(uriBuilder -> uriBuilder.path("/api/v1/crud-api/add-header").build())
				.bodyValue(memberDto)
				.header("my-header", "does api")
				.retrieve()
				.toEntity(MemberDto.class)
				.block();
	}

}
