package com.does.springbootcg.biz.repository;

import com.does.springbootcg.biz.domain.Category;
import com.does.springbootcg.biz.domain.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryRepositoryTest {

	@Autowired CategoryRepository categoryRepository;
	@Autowired ProductRepository productRepository;

	@Test
	public void saveTest() {
	    //given
		Product product = new Product();
		product.setName("pen");
		product.setPrice(1000);
		product.setStock(200);
		productRepository.save(product);

		Category category = new Category();
		category.setName("문구");
		category.setCode("s1");
		category.getProducts().add(product);
		categoryRepository.save(category);

	    //then
		List<Product> products = categoryRepository.findById(1L).get().getProducts();
		for (Product p : products) {
			System.out.println("p = " + p);
		}
	}

}