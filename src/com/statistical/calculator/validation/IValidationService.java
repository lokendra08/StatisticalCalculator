package com.statistical.calculator.validation;

import com.statistical.calculator.exception.CalculatorValidatorException;

/**
 * Service to perform validation on request input
 */
public interface IValidationService<T> {

	/**
	 * validate request input 
	 * 
	 * @param request request as input
	 * @return void
	 * @exception CalculatorValidatorException
	 */
	public void validateRequest(T t) throws CalculatorValidatorException;
}
