 package com.paramveerprakash.api.resourceobject;

import java.util.ArrayList;
import java.util.List;

import lombok.Setter;

@Setter
public class ProductsWrapper {

	private List<ProductDTO> products;
	
	public List<ProductDTO> getProducts() {
		if(null == products)
			products = new ArrayList<ProductDTO>();
		return products;
	}

}
