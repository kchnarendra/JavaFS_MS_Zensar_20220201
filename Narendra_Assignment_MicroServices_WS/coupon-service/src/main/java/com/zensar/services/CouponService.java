package com.zensar.services;

import com.zensar.dto.CouponDto;

public interface CouponService {

	public CouponDto createCoupon(CouponDto coupon);

	public CouponDto getCoupon(String couponCode);
}
