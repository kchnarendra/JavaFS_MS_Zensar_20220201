package com.zensar.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CouponDto {
	private int couponId;
	private String couponCode;
	private Double discount;
	private String expDate;
}
