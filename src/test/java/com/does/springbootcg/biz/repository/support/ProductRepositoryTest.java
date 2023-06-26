package com.does.springbootcg.biz.repository.support;

import com.does.springbootcg.biz.domain.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

	@Autowired ProductRepository productRepositorySupport;

	@Test
	public void findByNameTest() {
		List<Product> pens = productRepositorySupport.findByName("펜");
		for (Product pen : pens) {
			System.out.println("pen = " + pen);
		}
	}
}