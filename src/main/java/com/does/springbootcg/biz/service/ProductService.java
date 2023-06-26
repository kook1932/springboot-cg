package com.does.springbootcg.biz.service;

import com.does.springbootcg.biz.dto.ProductDto;
import com.does.springbootcg.biz.dto.ProductResponseDto;

public interface ProductService {

	ProductResponseDto getProduct(Long number);

	ProductResponseDto saveProduct(ProductDto productDto);

	ProductResponseDto changeProductName(Long number, String name) throws Exception;

	void deleteProduct(Long number) throws Exception;
}
