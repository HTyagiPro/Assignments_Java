package com.har.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.har.rest.entity.Passengers;
import com.har.rest.entity.Train;
import com.har.rest.exception.ResourceNotModifiedException;
import com.har.rest.repository.PassengersRepository;

@Service
public class PassengersService {
	
	@Autowired
	PassengersRepository passengerRepository;
	
	@Autowired
	RestTemplate restTemplate;

	@Transactional(readOnly = true)
	public List<Passengers> getAllPassengers(){
		return passengerRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public Passengers getPassengersById(int passId){
		Optional<Passengers> ot = passengerRepository.findById(passId);
		//System.out.println(ot.get());
		if (ot.isPresent()) {
			
			Passengers passenger = ot.get();
			Train train = restTemplate.getForEntity("http://localhost:8089/train/"+passenger.getTrainId(), Train.class).getBody();
			passenger.setTrain(train);
			return ot.get();
		}
		return null;
	}
	
	@Transactional
	public void insertOrModify(Passengers passengers) {
		if(passengerRepository.save(passengers)==null)
		throw new ResourceNotModifiedException();
	}
	
	@Transactional
	public boolean deletePassengerByPassengerId(int passId) {
		long count = passengerRepository.count();
		passengerRepository.deleteById(passId);
		if(passengerRepository.count()<count) return true;
		throw new ResourceNotModifiedException();
	}
}
