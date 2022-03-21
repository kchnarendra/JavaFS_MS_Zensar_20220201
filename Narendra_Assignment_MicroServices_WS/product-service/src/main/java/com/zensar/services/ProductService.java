package com.zensar.services;

import com.zensar.dto.CouponDto;
import com.zensar.dto.ProductDto;

public interface ProductService {

	ProductDto insertProduct(ProductDto productDto, CouponDto couponDto);

}
