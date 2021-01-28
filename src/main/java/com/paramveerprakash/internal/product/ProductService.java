package com.paramveerprakash.internal.product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paramveerprakash.api.resourceobject.ProductDTO;
import com.paramveerprakash.api.resourceobject.ProductsWrapper;
import org.modelmapper.ModelMapper;
@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	ModelMapper mapper = new ModelMapper();
	
	public ProductsWrapper getAllProducts() {
		Iterable<Product> products = productRepository.findAll();
		List<ProductDTO> productDtos = new ArrayList<>();
		Iterator<Product> pitr = products.iterator();
		
		while(pitr.hasNext()) {
			Product p = pitr.next();
			ProductDTO productDTO = mapper.map(p, ProductDTO.class);
			productDtos.add(productDTO);
		}
		ProductsWrapper wrapper = new ProductsWrapper();
		wrapper.setProducts(productDtos);
		return wrapper;
	}
	
	public ProductDTO getProductByID(String id) {
		if(productRepository.findById(id).isPresent()) {
			Product p = productRepository.findById(id).get();
			ProductDTO productDTO = mapper.map(p, ProductDTO.class);
			return productDTO;
		}
		return null;
	}
	
	public ProductDTO createProduct(ProductDTO productDto) {
		Product p =  mapper.map(productDto, Product.class);
		Product savedProduct  = productRepository.save(p);
		return mapper.map(savedProduct, ProductDTO.class);
	}
	
	public void updateProduct(ProductDTO productDto) {
		Product p =  mapper.map(productDto, Product.class);
		productRepository.save(p);
	}
	
	public void deleteProduct(String id) {
		productRepository.deleteById(id);
	}
}
