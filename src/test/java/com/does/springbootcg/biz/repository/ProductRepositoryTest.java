package com.does.springbootcg.biz.repository;

import com.does.springbootcg.biz.domain.Product;
import com.does.springbootcg.biz.domain.Provider;
import com.does.springbootcg.biz.domain.QProduct;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import java.util.List;

//@AutoConfigureTestDatabase(replace = Replace.NONE)
//@DataJpaTest
@SpringBootTest
class ProductRepositoryTest {

	@Autowired JPAQueryFactory jpaQueryFactory;
	@Autowired ProductRepository productRepository;
	@Autowired ProviderRepository providerRepository;

	@Test
	public void relationshipTest() throws Exception {
	    //given
		Provider provider = new Provider();
		provider.setName("물산");
		providerRepository.save(provider);

		Product product = new Product();
		product.setName("pen");
		product.setPrice(1000);
		product.setStock(200);
		product.setProvider(provider);
		productRepository.save(product);

		System.out.println(productRepository.findById(1L).orElseThrow(RuntimeException::new));
		System.out.println(productRepository.findById(1L).orElseThrow(RuntimeException::new).getProvider());

	}

	@Test
	public void queryDslTest() throws Exception {
		QProduct qProduct = QProduct.product;

		List<Product> pens = jpaQueryFactory
				.select(qProduct)
				.from(qProduct)
				.where(qProduct.name.eq("펜"))
				.orderBy(qProduct.price.asc())
				.fetch();

		pens.forEach(pen -> System.out.println("pen = " + pen));
	}

	@Test
	public void saveTest() throws Exception {
	    //given
		Product product = new Product();
		product.setName("pen");
		product.setPrice(1000);
		product.setStock(1234);

		//when
		Product saved = productRepository.save(product);

		//then
		Assertions.assertThat(saved.getName()).isEqualTo(product.getName());
		Assertions.assertThat(saved.getPrice()).isEqualTo(product.getPrice());
		Assertions.assertThat(saved.getStock()).isEqualTo(product.getStock());
		System.out.println("saved.getCreatedAt() = " + saved.getCreatedAt());
	}

	@Test
	public void findByNameTest() {
		Product product1 = new Product();
		product1.setName("pen");
		product1.setPrice(2000);
		product1.setStock(12341);

		Product product2 = new Product();
		product2.setName("pen");
		product2.setPrice(3000);
		product2.setStock(12343);

		Product product3 = new Product();
		product3.setName("pen");
		product3.setPrice(1000);
		product3.setStock(12342);

		Product saved1 = productRepository.save(product1);
		Product saved2 = productRepository.save(product2);
		Product saved3 = productRepository.save(product3);

		List<Product> pens = productRepository.findByName("pen", PageRequest.of(0, 2)).getContent();
		System.out.println("pens = " + pens);

	}

	@Test
	public void selectTest() {
	    //given
		Product product = new Product();
		product.setName("pen");
		product.setPrice(1000);
		product.setStock(1234);

		Product saved = productRepository.saveAndFlush(product);

		//when
		Product found = productRepository.findById(saved.getNumber()).get();

		//then
		Assertions.assertThat(found.getName()).isEqualTo(saved.getName());
	}

}