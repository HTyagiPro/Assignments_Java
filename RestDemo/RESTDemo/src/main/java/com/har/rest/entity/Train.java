package com.har.rest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/*
 * mysql> desc train;
+--------------+--------+------+-----+---------+-------+
| Field        | Type   | Null | Key | Default | Extra |
+--------------+--------+------+-----+---------+-------+
| trainId      | int    | YES  |     | NULL    |       |
| trainName    | text   | YES  |     | NULL    |       |
| source       | text   | YES  |     | NULL    |       |
| destination  | text   | YES  |     | NULL    |       |
| compartments | int    | YES  |     | NULL    |       |
| fare         | double | YES  |     | NULL    |       |
+--------------+--------+------+-----+---------+-------+
6 rows in set (0.05 sec)

mysql> desc passengers;
+----------+--------+------+-----+---------+-------+
| Field    | Type   | Null | Key | Default | Extra |
+----------+--------+------+-----+---------+-------+
| passId   | int    | YES  |     | NULL    |       |
| passName | text   | YES  |     | NULL    |       |
| passMob  | bigint | YES  |     | NULL    |       |
| passAge  | int    | YES  |     | NULL    |       |
| trainId  | int    | YES  |     | NULL    |       |
+----------+--------+------+-----+---------+-------+
5 rows in set (0.00 sec)
 * 
 * 
 * */


@Entity
public class Train {
	@Id
	@Column(name = "train_id")
	private int trainId;
	private String trainName;
	private String source;
	private String destination;
	private int compartments;
	private double fare;
	
	public Train() {
	}

	public Train(int trainId, String trainName, String source, String destination, int compartments, double fare) {
		this.trainId = trainId;
		this.trainName = trainName;
		this.source = source;
		this.destination = destination;
		this.compartments = compartments;
		this.fare = fare;
	}

	public int getTrainId() {
		return trainId;
	}

	public void setTrainId(int trainId) {
		this.trainId = trainId;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getCompartments() {
		return compartments;
	}

	public void setCompartments(int compartments) {
		this.compartments = compartments;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	@Override
	public String toString() {
		return "Train:-\n------------------\n\tTrain ID: " + trainId + "\n\tTrain Name: " + trainName + "\n\tSource: " + source + "\n\tDestination: "
				+ destination + "\n\tCompartments: " + compartments + "\n\tFare: " + fare + "\n------------------\n";
	}
	
	
	
}

































