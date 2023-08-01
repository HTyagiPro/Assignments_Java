package com.har.spcd.beans;

import java.util.List;
import java.util.Map;

public class Country {
	private String countryName;
	private String currencyName;
	//private List<String> states;
	private Map<String, String> states;
	public Country(String countryName, String currencyName, Map<String, String> states) {
		this.countryName = countryName;
		this.currencyName = currencyName;
		this.states = states;
	}
	public Country() {
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCurrencyName() {
		return currencyName;
	}
	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}
	public Map<String, String> getStates() {
		return states;
	}
	public void setStates(Map<String, String> states) {
		this.states = states;
	}
	@Override
	public String toString() {
		String s = "\n\t";
		for(String a:states.keySet())
			s += a + "\t"+states.get(a) +"\n\t";
		return "Country\n------------------------------------\nCountry Name: " + countryName + "\nCurrency Name: " + currencyName + "\nStates:-" + s + "\n------------------------------------\n";
	}
	
	
}
