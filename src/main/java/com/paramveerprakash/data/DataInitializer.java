package com.paramveerprakash.data;

import java.math.BigDecimal;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.paramveerprakash.api.resourceobject.ProductDTO;
import com.paramveerprakash.internal.product.ProductService;
import com.paramveerprakash.internal.user.Credential;
import com.paramveerprakash.internal.user.CredentialService;

@Component
public class DataInitializer implements InitializingBean {

	@Autowired
	ProductService productService;
	
	@Autowired
	CredentialService credService;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		
	}
	
	@PostConstruct
    public void postConstruct() {
		createDummyCredentials();
		createDummyProducts();
    }

    private void createDummyCredentials() {
    	credService.createCreds(new Credential("admin","admin"));
    	credService.createCreds(new Credential("john","doe"));
    	credService.createCreds(new Credential("jane","doe"));
	}

	private void createDummyProducts() {
    	for(int i=0;i<10;i++) {
			ProductDTO p = new ProductDTO();
			p.setSku(String.valueOf(i));
			p.setName("Dummy Product "+i);
			p.setPrice(BigDecimal.valueOf(99.9).add(BigDecimal.ONE));
			productService.createProduct(p);
		}
	}

	public void init() {
    }

}
