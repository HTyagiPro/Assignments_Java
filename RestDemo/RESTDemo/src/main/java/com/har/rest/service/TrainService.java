package com.har.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.har.rest.entity.Train;
import com.har.rest.repository.TrainRepository;



@Service
public class TrainService {
	@Autowired
	TrainRepository trainRepository;
	
	@Transactional(readOnly=true)
	public List<Train> getAllTrain(){
		return trainRepository.findAll();
	}
	
	@Transactional(readOnly=true)
	public Train getTrainByTrainId(@PathVariable int train_id){
		Optional<Train> ot = trainRepository.findById(train_id);
		if(ot.isPresent()) return ot.get();
		return null;
	}
}
