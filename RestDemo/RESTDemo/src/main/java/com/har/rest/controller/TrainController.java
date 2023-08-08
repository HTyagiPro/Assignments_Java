package com.har.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.har.rest.entity.Train;
import com.har.rest.service.TrainService;

/*
@Controller
@ResponseBody
*/
@RestController
public class TrainController {
	@Autowired
	TrainService trainService;
	
	@GetMapping("/")
	public List<Train> getAllTrains(){
		return trainService.getAllTrain();
	}
	
	@GetMapping("/{trainId}")
	public Train getTrainsByTrainId(int train_id){
		return trainService.getTrainByTrainId(train_id);
	}
}
