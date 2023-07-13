package com.har.UnitTest.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.har.testDemo.Utility;

class TestSearch {
	Utility u = null;
	
	@BeforeEach
	void setUp() throws Exception {
		u = new Utility();
	}

	@AfterEach
	void tearDown() throws Exception {
		u = null;
		
	}

	@Test
	void test() {
		assertEquals(true, u.isElementExist(5,1,3,6,5,10,132));
	}
	
	@ParameterizedTest
	@CsvSource(value = {"true, 12","false, 11","true, 120","true, 122","false, 121",})
	public void isEvenTest(boolean expVal, int actVal) {
		assertEquals(expVal, u.isEven(actVal));
	}
	

}
