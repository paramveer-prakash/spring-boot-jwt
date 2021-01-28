 package com.paramveerprakash.api.resourceobject;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {

	private String id;
	private String sku;
	private String name;
	private BigDecimal price;
}
