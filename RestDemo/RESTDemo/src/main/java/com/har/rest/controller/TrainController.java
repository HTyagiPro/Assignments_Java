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
import com.har.rest.entity.Train;
import com.har.rest.exception.ResourceNotFoundException;
import com.har.rest.exception.ResourceNotModifiedException;
import com.har.rest.service.TrainService;

/*
@Controller
@ResponseBody
*/
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "train")
public class TrainController {
	@Autowired
	TrainService trainService;
	
	@GetMapping(value="/", produces = "application/json")
	public List<Train> getAllTrains(){
		return trainService.getAllTrain();
	}
	
	@GetMapping(value="/{train_id}", produces = "application/json")
	public ResponseEntity<Train> getTrainsByTrainId(@PathVariable int train_id){
		Train t = trainService.getTrainByTrainId(train_id);
		if(t!=null)
			return new ResponseEntity<Train>(t, HttpStatus.OK);
		return new ResponseEntity<Train>(t, HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(value = "/", consumes = "application/json")
	public HttpStatus insertTrain(@RequestBody Train train) {
		trainService.insertOrModifyTrain(train);
			return HttpStatus.OK;
		
	}
	
	@PutMapping(value = "/", consumes = "application/json")
	public HttpStatus modifyTrain(@RequestBody Train train) {
		trainService.insertOrModifyTrain(train);
			return HttpStatus.OK;
	
	}
	
	@DeleteMapping(value = "/{train_id}", consumes = "application/json")
	public HttpStatus deleteTrain(@PathVariable int train_id) {
		if(trainService.deleteTrainById(train_id))
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
