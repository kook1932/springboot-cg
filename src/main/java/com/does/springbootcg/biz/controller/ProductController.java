package com.does.springbootcg.biz.controller;

import com.does.springbootcg.biz.dto.ChangeProductNameDto;
import com.does.springbootcg.biz.dto.ProductDto;
import com.does.springbootcg.biz.dto.ProductResponseDto;
import com.does.springbootcg.biz.service.ProductService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/product")
@RestController
public class ProductController {

	private final ProductService productService;

	@GetMapping()
	public ResponseEntity<ProductResponseDto> getProduct(Long number) {
		ProductResponseDto productResponseDto = productService.getProduct(number);
		return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
	}

	@ApiImplicitParams({
			@ApiImplicitParam(name = "X-AUTH-TOKEN", value = "로그인 성공 후 발급 받은 access_token", required = true, dataType = "String", paramType = "header")
	})
	@PostMapping()
	public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductDto productDto) {
		ProductResponseDto productResponseDto = productService.saveProduct(productDto);
		return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
	}

	@PutMapping()
	public ResponseEntity<ProductResponseDto> changeProductName(@RequestBody ChangeProductNameDto changeProductNameDto) throws Exception {
		ProductResponseDto productResponseDto = productService.changeProductName(changeProductNameDto.getNumber(), changeProductNameDto.getName());
		return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
	}

	@DeleteMapping()
	public ResponseEntity<String> deleteProduct(Long number) throws Exception {
		productService.deleteProduct(number);
		return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
	}
}
