package com.zensar.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.entity.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {

	Optional<Coupon> findByCouponCode(String couponCode);
}
