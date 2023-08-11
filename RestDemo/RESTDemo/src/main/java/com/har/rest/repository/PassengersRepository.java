package com.har.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.har.rest.entity.Passengers;

public interface PassengersRepository extends JpaRepository<Passengers, Integer> {

}
