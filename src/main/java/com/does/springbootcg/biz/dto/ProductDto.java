package com.does.springbootcg.biz.dto;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {

	private String name;
	private int price;
	private int stock;

}
