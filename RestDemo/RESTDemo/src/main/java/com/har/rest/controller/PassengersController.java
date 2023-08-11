package com.har.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.har.rest.entity.Passengers;
import com.har.rest.exception.ResourceNotFoundException;
import com.har.rest.exception.ResourceNotModifiedException;
import com.har.rest.service.PassengersService;

@RestController
@RequestMapping(value = "/passengers")
public class PassengersController {
	@Autowired
	PassengersService passengersService;
	
	@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity<List<Passengers>> getAllPassengers(){
		List<Passengers> plist = passengersService.getAllPassengers();
		if(plist.size()!=0) return new ResponseEntity<List<Passengers>>(plist, HttpStatus.OK);
		return new ResponseEntity<List<Passengers>>(plist, HttpStatus.NOT_FOUND);
	}
	
	
	@GetMapping(value = "/{passId}")
	public ResponseEntity<Passengers> getPassengersById(@PathVariable int passId){
		Passengers p = passengersService.getPassengersById(passId);
		if(p!=null) return new ResponseEntity<Passengers>(p, HttpStatus.OK);
		return new ResponseEntity<Passengers>(p, HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(value = "/")
	public HttpStatus insertPassengers(@RequestBody Passengers passenger) {
		passengersService.insertOrModify(passenger) ;
		return HttpStatus.OK;
		
	}
	
	@PutMapping(value = "/")
	public HttpStatus modifyPassengers(@RequestBody Passengers passenger) {
		passengersService.insertOrModify(passenger);
		return HttpStatus.OK;
		
	}
	
	@DeleteMapping(value = "/{passId}")
	public HttpStatus deletePassengers(@PathVariable int passId) {
		if(passengersService.deletePassengerByPassengerId(passId)) return HttpStatus.OK;
		return HttpStatus.NOT_MODIFIED;
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
