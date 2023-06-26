package com.does.springbootcg.biz.service.impl;

import com.does.springbootcg.biz.dao.impl.ProductDAOImpl;
import com.does.springbootcg.biz.domain.Product;
import com.does.springbootcg.biz.dto.ProductDto;
import com.does.springbootcg.biz.dto.ProductResponseDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

	@Mock
	private ProductDAOImpl productDAO;  // mock 객체를 생성하여 주입, @ExtendWith(MockitoExtension.class) 선언 필요

	@InjectMocks
	private ProductServiceImpl productService;  // mock 객체들을 감지하여 생성자 주입 실행

	@Test
	public void getProductTest() {
	    //given
		Product givenProduct = new Product();
		givenProduct.setNumber(123L);
		givenProduct.setName("펜");
		givenProduct.setPrice(1000);
		givenProduct.setStock(1234);

		given(productDAO.selectProduct(123L))
				.willReturn(givenProduct);

		//when
		ProductResponseDto productResponseDto = productService.getProduct(123L);

		//then
		Assertions.assertThat(productResponseDto.getNumber()).isEqualTo(givenProduct.getNumber());
		Assertions.assertThat(productResponseDto.getName()).isEqualTo(givenProduct.getName());
		Assertions.assertThat(productResponseDto.getPrice()).isEqualTo(givenProduct.getPrice());
		Assertions.assertThat(productResponseDto.getStock()).isEqualTo(givenProduct.getStock());
		System.out.println("productResponseDto = " + productResponseDto);

		then(productDAO).should().selectProduct(123L);

	}

	@Test
	public void saveProductTest() throws Exception {
	    //given
		Product pen = new Product();
		pen.setNumber(123L);
		pen.setName("pen");
		pen.setPrice(1000);
		pen.setStock(1234);

		given(productDAO.insertProduct(any(Product.class)))
				.willReturn(pen);

	    //when
		ProductResponseDto prd = productService.saveProduct(new ProductDto("pen", 1000, 1234));

		//then
		Assertions.assertThat(prd.getName()).isEqualTo("pen");
		Assertions.assertThat(prd.getPrice()).isEqualTo(1000);
		Assertions.assertThat(prd.getStock()).isEqualTo(1234);
		then(productDAO).should().insertProduct(any());
	}

}