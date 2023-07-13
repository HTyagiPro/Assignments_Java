package com.har.Arsenal_maven;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCalc {
	
	Calc c = null;
	@BeforeEach
	public void setUp() throws Exception{
		c = new Calc();
	}
	
	@AfterEach
	public void tearDown() throws Exception{
		c = null;
	}
	
	@Test
	public void testSq() throws Exception{
		assertEquals(1225, c.square(35));
	}
	
	@Test
	public void testSum() throws Exception{
		assertEquals(1225, c.sum(613,612));
	}
	
	@Test
	public void testPow() throws Exception{
		assertEquals(512, c.power(2,9));
	}

}
