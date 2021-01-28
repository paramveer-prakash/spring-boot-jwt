package com.paramveerprakash.api.resource;

import java.net.URI;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.paramveerprakash.api.resourceobject.ProductDTO;
import com.paramveerprakash.api.resourceobject.ProductsWrapper;
import com.paramveerprakash.internal.product.ProductService;

@RestController
@RequestMapping("/products")
public class ProductResource {
	
	@Autowired
	ProductService productService;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductDTO> getProductByID(@PathVariable("id") String id) {
		ProductDTO productDTO = productService.getProductByID(id);
		return ResponseEntity.ok(productDTO);
	}
	
	@GetMapping
	public ResponseEntity<ProductsWrapper> getProductByID() {
		ProductsWrapper pw = productService.getAllProducts();		
		return ResponseEntity.ok(pw);
	}
	
	@PostMapping
	public ResponseEntity<Object> createProduct(@RequestBody ProductDTO productDto,UriComponentsBuilder builder){
		ProductDTO dto = productService.createProduct(productDto);
		URI location = builder.replacePath("/products/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(location).body(Collections.singletonMap("id", dto.getId()));
	}
	
	@PutMapping
	public ResponseEntity<String> updateProduct(@RequestBody ProductDTO productDto){
		productService.updateProduct(productDto);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") String id){
		productService.deleteProduct(id);
		return ResponseEntity.noContent().build();
	}
	 
}
