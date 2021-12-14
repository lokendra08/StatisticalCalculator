package com.statistical.calculator.objectfactory;

import com.statistical.calculator.service.ICalculatorService;
import com.statistical.calculator.validation.IValidationService;

/**
 * Handles object creation.
 * This is factory of factory for services catering object creation for services.
 */
public abstract class AbstractFactory {

	/**
	 * Returns an implementation of ICalculatorService based on passed serviceIndicator.
	 * 
	 * @param serviceIndicator user input serviceIndicator
	 * @return AirthmaticOperation
	 */
	public abstract ICalculatorService<?> getCalculatorService(String serviceIndicator);
	
	/**
	 * Returns an implementation of IValidationService based on passed serviceIndicator.
	 * 
	 * @param serviceIndicator user input serviceIndicator
	 * @return CalculatorValidatorService
	 */
	public abstract IValidationService<?> getCalculatorValidatorService(String serviceIndicator);

}
