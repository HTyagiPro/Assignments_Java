package com.har.airModel;

import java.time.LocalDate;
import java.util.ArrayList;

public class MainAirport {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
		ArrayList<Flight> fList = new ArrayList<Flight>();
		ArrayList<Traveller> tList = new ArrayList<Traveller>();
		
		Airport ap = new Airport(new Address("Chandni Chowk", "New Delhi", "Delhi"), fList, tList);
		Flight f1 = new Flight("A101", "Delhi", "Hyderabad", 7499.35, 76, "18:26:23","23:26:23", "Indigo");
		Flight f2 = new Flight("A103", "Bombay", "Banglore", 7499.35, 76, "18:26:23","23:26:23", "Indigo");
		Flight f3 = new Flight("A101", "Hyderabad", "Vadodhra", 7499.35, 76, "18:26:23","23:26:23", "Indigo");
		Flight f4 = new Flight("A105", "West Bengal", "Hyderabad", 7499.35, 76, "18:26:23","23:26:23", "Indigo");
		Flight f5 = new Flight("A104", "Hyderabad", "Bhopal", 7499.35, 76, "18:26:23","23:26:23", "Indigo");
		
		
		
		Traveller t1 = new Traveller("Harshit", "7078179015", "tyagiharshit988@gmail.com", "A103", LocalDate.of(2023, 7, 27));
		Traveller t2 = new Traveller("Aman", "9865655433", "aman.gupta@prolifics.com", "A105", LocalDate.of(2023, 7, 27));
		Traveller t3 = new Traveller("Mitesh", "8138547660", "mitesh.gautam@prolifics.com", "A104", LocalDate.of(2023, 7, 27));
		Traveller t4 = new Traveller("Abhinav", "9876246256", "Abhinav.kumar@prolifics.com", "A105", LocalDate.of(2023, 7, 27));
		Traveller t5 = new Traveller("Diksha", "9734656446", "diksha.singh@prolifics.com", "A101", LocalDate.of(2023, 7, 27));
		
		fList.add(f1);
		fList.add(f2);
		fList.add(f3);
		fList.add(f4);
		fList.add(f5);
		
		tList.add(t1);
		tList.add(t2);
		tList.add(t3);
		tList.add(t4);
		tList.add(t5);
		
		/*
		for(Flight f: ap.searchFlightsBySourceAndDestination("Bombay", "Banglore"))
			System.out.println(f);
		*/
		
		/*
		ap.bookTicket("A103", t1);
		*/
		
		
		/*
		Flight f6 = new Flight("A106", "Jaipur", "Lucknow", 7499.35, 76, "18:26:23","23:26:23", "Indigo");
		System.out.println("Flight Added: "+ ap.addFlight(f6));
		*/
		
		
		for(Flight f:fList)
			System.out.println(f);
		
		for(Traveller t:tList)
			System.out.println(t);
		
		}
		catch(RuntimeException e){
			System.out.println(e);
			
		}
		
	}

}
