package com.zensar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.entity.Coupon;
import com.zensar.services.CouponService;

@RestController
@RequestMapping("/coupons")
@RefreshScope
public class CouponController {

	@Value("${env.name}")
	private String envName;
	
	@Value("${server.instance.name}")
	private String instanceName;
	
	@Autowired
	private CouponService couponService;

	@PostMapping("/")
	public Coupon createCoupon(@RequestBody Coupon coupon) {
		return couponService.createCoupon(coupon);
	}

	@GetMapping("/{couponCode}")
	public Coupon getCoupon(@PathVariable("couponCode") String couponCode) {
		System.out.println("Response from " + instanceName);
		return couponService.getCoupon(couponCode);
	}
	
	@GetMapping("/")
	public String getMessage() {
		return envName;
	}
}
