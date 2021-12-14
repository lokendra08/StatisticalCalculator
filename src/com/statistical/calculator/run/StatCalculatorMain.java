package com.statistical.calculator.run;

import com.statistical.calculator.util.CalcDisplayBanner;
/**
 * Main class
 *
 */
public class StatCalculatorMain {

	static {
		CalcDisplayBanner.displayInfo();
	}

	public static void main(String[] args) {
		StatCalculatorDriver statCalculatorDriver = new StatCalculatorDriver();
		statCalculatorDriver.run();
	}
}
