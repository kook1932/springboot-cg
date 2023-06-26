package com.does.springbootcg.biz.controller;

import com.does.springbootcg.biz.dto.ProductDto;
import com.does.springbootcg.biz.dto.ProductResponseDto;
import com.does.springbootcg.biz.service.impl.ProductServiceImpl;
import com.google.gson.Gson;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	ProductServiceImpl productService;

	@DisplayName("MockMvc 를 통한 Product 데이터 가져오기 테스트")
	@Test
	public void getProductTest() throws Exception {
		//given
		given(productService.getProduct(123L))
				.willReturn(new ProductResponseDto(123L, "pen", 5000, 2000));

		String productId = "123";

		//when
		mockMvc.perform(get("/product?number=" + productId))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.number").exists())
				.andExpect(jsonPath("$.price").exists())
				.andExpect(jsonPath("$.stock").exists())
				.andDo(print());

		//then
		verify(productService).getProduct(123L);
	}

	@DisplayName("Product 데이터 생성 테스트")
	@Test
	public void createProductTest() throws Exception {
		given(productService.saveProduct(new ProductDto("pen", 5000, 2000)))
				.willReturn(new ProductResponseDto(12345L, "pen", 5000, 2000));

		ProductDto productDto = ProductDto.builder()
				.name("pen")
				.price(5000)
				.stock(2000)
				.build();

		Gson gson = new Gson();
		String content = gson.toJson(productDto);

		mockMvc.perform(post("/product")
						.content(content)
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.number").exists())
				.andExpect(jsonPath("$.name").exists())
				.andExpect(jsonPath("$.price").exists())
				.andExpect(jsonPath("$.stock").exists())
				.andDo(print());

		verify(productService).saveProduct(new ProductDto("pen", 5000, 2000));

	}
}