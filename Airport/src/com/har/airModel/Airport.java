package com.har.airModel;
import java.util.ArrayList;


public class Airport{
	Address address;
	ArrayList<Flight> flights = new ArrayList<Flight>();
	ArrayList<Traveller> travellers = new ArrayList<Traveller>();
	
	public Airport(Address address, ArrayList<Flight> flights, ArrayList<Traveller> travellers) {
		this.address = address;
		this.flights = flights;
		this.travellers = travellers;
	}
	
	
	public boolean addFlight(Flight f) throws RuntimeException {
		if(this.flights.add(f))
			return true;
		else 
			throw new RuntimeException("Flight Can not be added!!!");
	}
	
	public ArrayList<Flight> searchFlightsBySourceAndDestination(String source, String destination) {
		ArrayList<Flight> flightList = new ArrayList<Flight>();
		boolean found = false;
		for(Flight f:flights) {
			if (f.source.equals(source) && f.destination.equals(destination) ) {
				flightList.add(f);
				found = true;
			}
		}
		if(found)
			return flightList;
		else
			throw new RuntimeException("Flight Not Found");
			
	}
	
	public void bookTicket(String flightId, Traveller tvr) throws RuntimeException {
		boolean booked = false;
		for (Flight f: flights) {
			if(f.getId().equals(flightId) && f.getTotalSeats()>0) {
				f.setTotalSeats(f.getTotalSeats()-1);
				System.out.println(tvr);
				System.out.println(f);
				booked = true;
			}
		}
		
		if(!booked)
			throw new RuntimeException("Flight not Available!!!");
		
	}
	
	
	
	
	
}
