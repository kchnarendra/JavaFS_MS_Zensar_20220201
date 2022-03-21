package com.zensar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.dto.CouponDto;
import com.zensar.dto.ProductDto;
import com.zensar.rest.template.CouponClient;
import com.zensar.services.ProductService;

import io.github.resilience4j.retry.annotation.Retry;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
//@RequestMapping("/products")
@OpenAPIDefinition(info = @Info(title = "Product Api", description = "This api is for product", version = "1.0"))
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CouponClient couponClient;

	@PostMapping("/")
	//@Retry(fallbackMethod = "myFallBackMethod", name = "productApi")
	public @ApiResponse(description = "It is used to create a product") ResponseEntity<ProductDto> insertProduct(
			@RequestBody ProductDto productDto) {

		CouponDto couponDto = couponClient.getCoupon(productDto.getCoupanCode());
		ProductDto productDto2 = productService.insertProduct(productDto, couponDto);
		return new ResponseEntity<ProductDto>(productDto2, HttpStatus.CREATED);
	}

	public ProductDto myFallBackMethod(@RequestBody ProductDto product, Exception e) {
		return new ProductDto();
	}
}
