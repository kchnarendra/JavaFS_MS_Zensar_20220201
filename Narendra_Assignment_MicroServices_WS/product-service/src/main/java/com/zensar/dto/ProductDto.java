package com.zensar.dto;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class ProductDto {
	private int productId;
	private String productName;
	private String discription;
	private Double price;
	private String coupanCode;
}
