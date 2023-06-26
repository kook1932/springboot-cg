package com.does.springbootcg.biz.dto;

import lombok.*;

@Getter @Setter @AllArgsConstructor @ToString
public class ProductResponseDto {

	private Long number;
	private String name;
	private int price;
	private int stock;

	public static ProductResponseDtoBuilder builder() {
		return new ProductResponseDtoBuilder();
	}

	@NoArgsConstructor
	public static class ProductResponseDtoBuilder {
		private Long number;
		private String name;
		private int price;
		private int stock;

		public ProductResponseDtoBuilder number(Long number) {
			this.number = number;
			return this;
		}

		public ProductResponseDtoBuilder name(String name) {
			this.name = name;
			return this;
		}

		public ProductResponseDtoBuilder price(int price) {
			this.price = price;
			return this;
		}

		public ProductResponseDtoBuilder stock(int stock) {
			this.stock = stock;
			return this;
		}

		public ProductResponseDto build() {
			return new ProductResponseDto(number, name, price, stock);
		}

	}
}
