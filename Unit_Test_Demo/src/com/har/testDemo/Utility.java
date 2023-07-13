package com.har.testDemo;

public class Utility {
	
	public boolean isElementExist(int target, int ...arr) {
		
		for(int j:arr) {
			if (j == target)
				return true; 
		}
		return false;
	}
	
	public boolean isEven(int n) {
		return n%2==0;
	}
}
