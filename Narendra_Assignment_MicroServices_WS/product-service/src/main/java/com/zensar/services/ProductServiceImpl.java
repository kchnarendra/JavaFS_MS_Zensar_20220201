package com.zensar.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.dto.CouponDto;
import com.zensar.dto.ProductDto;
import com.zensar.entity.Product;
import com.zensar.exception.ProductCreationFiailureException;
import com.zensar.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public ProductDto insertProduct(ProductDto productDto, CouponDto couponDto){
		
		ProductDto productDto2 = null;
		try {
			Product product = modelMapper.map(productDto, Product.class);
			product.setPrice(productDto.getPrice() - couponDto.getDiscount());
			Product product2 = productRepository.save(product);
			productDto2 = modelMapper.map(product2, ProductDto.class);
		} catch (Exception e) {
			throw new ProductCreationFiailureException("Failled to create product " + e);
		}	
		return productDto2;
	}
}
