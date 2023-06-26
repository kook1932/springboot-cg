package com.does.springbootcg.biz.repository;

import com.does.springbootcg.biz.domain.Product;
import com.does.springbootcg.biz.domain.ProductDetail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductDetailRepositoryTest {

	@Autowired ProductDetailRepository productDetailRepository;
	@Autowired ProductRepository productRepository;

	@Test
	public void saveAndReadTest1() throws Exception {
		Product product = new Product();
		product.setName("jpa");
		product.setPrice(5000);
		product.setStock(1000);
		Product savedProduct = productRepository.save(product);

		ProductDetail detail = new ProductDetail();
		detail.setProduct(savedProduct);
		detail.setDescription("jpa detail");
		productDetailRepository.save(detail);

		System.out.println("savedProduct = " + productDetailRepository.findById(detail.getId()).get().getProduct());
		System.out.println("savedProductDetail = " + productDetailRepository.findById(detail.getId()).get());
	}

}