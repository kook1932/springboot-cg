package com.does.springbootcg.biz.repository;

import com.does.springbootcg.biz.domain.Product;
import com.does.springbootcg.biz.domain.QProduct;
import com.querydsl.core.types.Predicate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class QProductRepositoryTest {

	@Autowired QProductRepository qProductRepository;

	@Test
	public void queryDSLTest1() throws Exception {
		Predicate predicate = QProduct.product.name.equalsIgnoreCase("pen")
				.and(QProduct.product.price.between(1000, 2500));

		Optional<Product> found = qProductRepository.findOne(predicate);

		if (found.isPresent()) {
			System.out.println("found.get() = " + found.get());
		}
	}

}