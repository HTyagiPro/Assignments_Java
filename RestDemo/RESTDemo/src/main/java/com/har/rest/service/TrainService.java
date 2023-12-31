package com.har.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.har.rest.entity.Train;
import com.har.rest.exception.ResourceNotFoundException;
import com.har.rest.exception.ResourceNotModifiedException;
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
	public Train getTrainByTrainId(int train_id){
		Optional<Train> ot = trainRepository.findById(train_id);
		if(ot.isPresent()) return ot.get();
		throw new ResourceNotFoundException();
	}
	
	@Transactional
	public void insertOrModifyTrain(Train train) {
		if(trainRepository.save(train) == null) 
			throw new ResourceNotModifiedException();
	}
	
	@Transactional
	public boolean deleteTrainById(int train_id) {
		long count = trainRepository.count();
		trainRepository.deleteById(train_id);
		
		if(count > trainRepository.count())
			return true;
		throw new ResourceNotModifiedException();
	}
	
	
	
}
