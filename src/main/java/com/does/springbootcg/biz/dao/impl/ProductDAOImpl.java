package com.does.springbootcg.biz.dao.impl;

import com.does.springbootcg.biz.dao.ProductDAO;
import com.does.springbootcg.biz.domain.Product;
import com.does.springbootcg.biz.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Component
public class ProductDAOImpl implements ProductDAO {

	private final ProductRepository productRepository;

	@Override
	public Product insertProduct(Product product) {
		Product savedProduct = productRepository.save(product);
		return savedProduct;
	}

	@Override
	public Product selectProduct(Long number) {
		Product selectedProduct = productRepository.getById(number);
		return selectedProduct;
	}

	@Override
	public Product updateProductName(Long number, String name) throws Exception {
		Product selectedProduct = productRepository.findById(number).orElseThrow(Exception::new);

		selectedProduct.setName(name);
		selectedProduct.setCreatedAt(LocalDateTime.now());

		Product updatedProduct = productRepository.save(selectedProduct);
		return updatedProduct;
	}

	@Override
	public void deleteProduct(Long number) throws Exception {
		Product selectedProduct = productRepository.findById(number).orElseThrow(Exception::new);
		productRepository.delete(selectedProduct);
	}
}
