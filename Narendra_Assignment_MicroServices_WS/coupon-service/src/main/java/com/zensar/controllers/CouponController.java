package com.zensar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.zensar.dto.CouponDto;
import com.zensar.exception.CouponNotValidException;
import com.zensar.services.CouponService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
//@RequestMapping("/coupons")
@RefreshScope
@OpenAPIDefinition(info = @Info(title = "Coupon Api", description = "This api provides coupon details", version = "1.0"))
public class CouponController {

	@Autowired
	private CouponService couponService;

	@PostMapping("/")
	public @ApiResponse(description = "It returns created Coupon") ResponseEntity<CouponDto> createCoupon(
			@RequestBody CouponDto coupon) {

		CouponDto couponDto = couponService.createCoupon(coupon);
		return new ResponseEntity<CouponDto>(couponDto, HttpStatus.CREATED);
	}

	@GetMapping("/{couponCode}")
	public @ApiResponse(description = "It returns Coupon details based on coupon code") ResponseEntity<CouponDto> getCoupon(
			@Parameter(description = "You have to enter coupon code") @PathVariable("couponCode") String couponCode) {

		CouponDto couponDto = couponService.getCoupon(couponCode);
		return new ResponseEntity<CouponDto>(couponDto, HttpStatus.OK);
	}

	@ExceptionHandler(value = { CouponNotValidException.class })
	public ResponseEntity<String> handleCouponGettingErrors(RuntimeException exception, WebRequest request) {
		return new ResponseEntity<String>("Not a valid Coupon " + exception.getMessage(), HttpStatus.NO_CONTENT);
	}
}
