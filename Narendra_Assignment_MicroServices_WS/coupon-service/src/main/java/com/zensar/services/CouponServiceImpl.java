package com.zensar.services;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.dto.CouponDto;
import com.zensar.entity.Coupon;
import com.zensar.exception.CouponNotValidException;
import com.zensar.repository.CouponRepository;

@Service
public class CouponServiceImpl implements CouponService {
	
	@Autowired
	private CouponRepository couponRepository;

	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public CouponDto createCoupon(CouponDto couponDto) {
			
		CouponDto couponDto2 = null;
		try {
			Coupon couponEntity = modelMapper.map(couponDto, Coupon.class);	
			Coupon couponEntity1 = couponRepository.save(couponEntity);
			couponDto2 = modelMapper.map(couponEntity1, CouponDto.class);
		} catch (Exception e) {
			throw new CouponNotValidException("Failled to create coupon");
		}
		return couponDto2;
	}
	
	public CouponDto getCoupon(String couponCode) {
		
		CouponDto couponDto;
		Optional<Coupon> coupon = couponRepository.findByCouponCode(couponCode);
		
		if(coupon.isPresent()) {
			return couponDto = modelMapper.map(coupon.get(), CouponDto.class);
		}
		throw new CouponNotValidException(couponCode);
	}
}
