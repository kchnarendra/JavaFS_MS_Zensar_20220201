package com.zensar.rest.template;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.zensar.dto.CouponDto;

@FeignClient("GATEWAY-SERVICE")
public interface CouponClient {

	@GetMapping("/coupons/{couponCode}")
	CouponDto getCoupon(@PathVariable String couponCode);
}
