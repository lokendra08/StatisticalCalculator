package com.statistical.calculator.validation;

import com.statistical.calculator.exception.CalculatorValidatorException;
/*
 * Implementation class to validate request
 */
public class StatisticalCalculatorValidationService implements IValidationService<String>{

	
	/**
	 * validate request input 
	 * Checks if input is a valid numeric digit.
	 * @param input request as input
	 * @return void
	 * @exception CalculatorValidatorException
	 */
	@Override
	public void validateRequest(String input) throws CalculatorValidatorException {
		if(input.isEmpty()) {
			throw new CalculatorValidatorException(input+ ": No input entered. please try with valid input !!!");
		}
		if(input.isEmpty() || !input.matches("[0-9.]*")) {
			throw new CalculatorValidatorException(input+ ": is invalid number. please try with valid input !!!");
		}
	}

}
