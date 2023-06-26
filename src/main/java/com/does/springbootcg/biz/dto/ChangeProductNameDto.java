package com.does.springbootcg.biz.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class ChangeProductNameDto {
	private Long number;
	private String name;
}
