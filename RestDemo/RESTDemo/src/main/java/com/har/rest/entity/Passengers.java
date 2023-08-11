package com.har.rest.entity;

import com.har.rest.repository.TrainRepository;
import com.har.rest.service.TrainService;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Passengers {
	@Id
	@Column(name = "pass_id")
	private int passId;
	@Column(name = "pass_name")
	private String passName;
	@Column(name ="pass_mob" )
	private String passMob;
	@Column(name = "pass_age")
	private int passAge;
	@Column(name = "train_id")
	private int trainId;
	
	transient private Train train;
	
	
	
	public Passengers() {
	}






	public Passengers(int passId, String passName, String passMob, int passAge) {
		this.passId = passId;
		this.passName = passName;
		this.passMob = passMob;
		this.passAge = passAge;
		//this.trainId = trainId; , int trainId
	}






	public int getPassId() {
		return passId;
	}






	public void setPassId(int passId) {
		this.passId = passId;
	}






	public String getPassName() {
		return passName;
	}






	public void setPassName(String passName) {
		this.passName = passName;
	}






	public String getPassMob() {
		return passMob;
	}






	public void setPassMob(String passMob) {
		this.passMob = passMob;
	}






	public int getPassAge() {
		return passAge;
	}






	public void setPassAge(int passAge) {
		this.passAge = passAge;
	}






	public int getTrainId() {
		return trainId;
	}






	public void setTrainId(int trainId) {
		this.trainId = trainId;
	}





	public Train getTrain() {
		return train;
	}



	public void setTrain(Train train) {
		this.train = train;
	}

	
	
	
	@Override
	public String toString() {
		return "Passengers:-\n--------------------------\nPass_id: " + passId + "\nPass Name:" + passName + "\nPassMob: " + passMob + "\nPassAge: "
				+ passAge + "\nTrainId: " + trainId + "\n--------------------------\n";
	}






	
	
	
}
