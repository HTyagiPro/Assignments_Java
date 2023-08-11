package com.har.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.har.rest.entity.Product;
import com.har.rest.service.ProductService;
import com.har.rest.exception.ResourceNotFoundException;
import com.har.rest.exception.ResourceNotModifiedException;


@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping(value="/", produces = "application/json")
	public List<Product> getAllProduct(){
		return productService.getAllProduct();
	}
	
	@GetMapping(value="/{train_id}", produces = "application/json")
	public ResponseEntity<Product> getProductByProductId(@PathVariable int productId){
		Product t = productService.getProductByProductId(productId);
		if(t!=null)
			return new ResponseEntity<Product>(t, HttpStatus.OK);
		return new ResponseEntity<Product>(t, HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(value = "/", consumes = "application/json")
	public HttpStatus insertProduct(@RequestBody Product product) {
		productService.insertOrModifyProduct(product);
			return HttpStatus.OK;
		
	}
	
	@PutMapping(value = "/", consumes = "application/json")
	public HttpStatus modifyProduct(@RequestBody Product product) {
		productService.insertOrModifyProduct(product);
			return HttpStatus.OK;
	
	}
	
	@DeleteMapping(value = "/{train_id}", consumes = "application/json")
	public HttpStatus deleteProduct(@PathVariable int productId) {
		if(productService.deleteProductById(productId))
			return HttpStatus.OK;
		return HttpStatus.NOT_FOUND;
	}
	
	@ExceptionHandler(ResourceNotModifiedException.class)
	public HttpStatus notModifiedExceptionHandler() {
		return HttpStatus.NOT_MODIFIED;
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public HttpStatus notFoundExceptionHandler() {
		return HttpStatus.NOT_FOUND;
	}
	
}
