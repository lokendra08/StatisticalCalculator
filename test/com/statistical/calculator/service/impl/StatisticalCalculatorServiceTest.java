package com.statistical.calculator.service.impl;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StatisticalCalculatorServiceTest {
	
	public StatisticalCalculatorService statisticalCalculatorService;
	
	
	@BeforeEach 
    void setUp() {
		statisticalCalculatorService = new StatisticalCalculatorService();
		for(int i=1; i<=10;i++) {
			statisticalCalculatorService.event(i);
		}
		
    }
	
	@Test
	public void testGetMean() {
		assertEquals("5.5", String.valueOf(statisticalCalculatorService.getMean()));
		assertEquals("1.0", String.valueOf(statisticalCalculatorService.getMin()));
		assertEquals("10.0", String.valueOf(statisticalCalculatorService.getMax()));
		assertEquals("9.166666666666666", String.valueOf(statisticalCalculatorService.getVariance()));
		assertEquals(10, statisticalCalculatorService.getCount());
		assertEquals("55.0", String.valueOf(statisticalCalculatorService.getSum()));

	}
	
	

}
