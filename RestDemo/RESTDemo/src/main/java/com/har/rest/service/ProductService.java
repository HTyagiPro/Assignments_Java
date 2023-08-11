package com.har.rest.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.har.rest.entity.Product;
import com.har.rest.exception.ResourceNotFoundException;
import com.har.rest.exception.ResourceNotModifiedException;
import com.har.rest.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	
	@Transactional(readOnly=true)
	public List<Product> getAllProduct(){
		return productRepository.findAll();
	}
	
	@Transactional(readOnly=true)
	public Product getProductByProductId(int productId){
		Optional<Product> ot = productRepository.findById(productId);
		if(ot.isPresent()) return ot.get();
		throw new ResourceNotFoundException();
	}
	
	@Transactional
	public void insertOrModifyProduct(Product product) {
		if(productRepository.save(product) == null) 
			throw new ResourceNotModifiedException();
	}
	
	@Transactional
	public boolean deleteProductById(int productId) {
		long count = productRepository.count();
		productRepository.deleteById(productId);
		
		if(count > productRepository.count())
			return true;
		throw new ResourceNotModifiedException();
	}
	
}
