package com.does.springbootcg.biz.service.impl;

import com.does.springbootcg.biz.dao.ProductDAO;
import com.does.springbootcg.biz.domain.Product;
import com.does.springbootcg.biz.dto.ProductDto;
import com.does.springbootcg.biz.dto.ProductResponseDto;
import com.does.springbootcg.biz.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

	private final ProductDAO productDAO;

	@Override
	public ProductResponseDto getProduct(Long number) {
		Product product = productDAO.selectProduct(number);
		return new ProductResponseDto.ProductResponseDtoBuilder()
				.number(product.getNumber())
				.name(product.getName())
				.price(product.getPrice())
				.stock(product.getStock())
				.build();
	}

	@Override
	public ProductResponseDto saveProduct(ProductDto productDto) {
		Product product = new Product();
		product.setName(productDto.getName());
		product.setPrice(productDto.getPrice());
		product.setStock(productDto.getStock());
		product.setCreatedAt(LocalDateTime.now());
		product.setUpdatedAt(LocalDateTime.now());

		Product savedProduct = productDAO.insertProduct(product);

		return new ProductResponseDto.ProductResponseDtoBuilder()
				.number(savedProduct.getNumber())
				.name(savedProduct.getName())
				.price(savedProduct.getPrice())
				.stock(savedProduct.getStock())
				.build();
	}

	@Override
	public ProductResponseDto changeProductName(Long number, String name) throws Exception {
		Product changedProduct = productDAO.updateProductName(number, name);

		return new ProductResponseDto.ProductResponseDtoBuilder()
				.number(changedProduct.getNumber())
				.name(changedProduct.getName())
				.price(changedProduct.getPrice())
				.stock(changedProduct.getStock())
				.build();
	}

	@Override
	public void deleteProduct(Long number) throws Exception {
		productDAO.deleteProduct(number);
	}
}
