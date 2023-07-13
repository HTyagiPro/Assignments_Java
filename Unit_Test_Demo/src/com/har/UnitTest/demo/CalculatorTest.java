package com.har.UnitTest.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.har.testDemo.Calc;

class CalculatorTest {

	static Calc c = null;
	//@BeforeEach
	@BeforeAll
	static void setUp() throws Exception {
		c = new Calc();
	}
	
	//@AfterEach
	@AfterAll
	static void tearDown() throws Exception {
		c = null;
	}
	
	@Test
	void sumtest() {
		assertEquals(150,c.sum(10,20,30,40,50));
	}
	
	@Test
	void powtest() {
		assertEquals(1024,c.power(2, 10));
	}
	@Test
	void sqtest() {
		assertEquals(1225,c.square(35));
	}

}
