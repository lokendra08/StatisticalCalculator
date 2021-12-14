package com.statistical.calculator.objectfactory;

import java.util.HashMap;
import java.util.Map;
import com.statistical.calculator.constant.CalculatorConstants;
import com.statistical.calculator.service.ICalculatorService;
import com.statistical.calculator.validation.IValidationService;
import com.statistical.calculator.validation.StatisticalCalculatorValidationService;

/**
 * factory class to hold objects
 *
 */
public class CalculatorValidatorServiceFactory extends AbstractFactory {

	static Map<String, IValidationService> mapOfValidatorObjects = new HashMap<String, IValidationService>() {
		{
			put(CalculatorConstants.STATISTICAL_REQUEST_VALIDATION, new StatisticalCalculatorValidationService());
		}
	};

	/**
	 * return desired object based on passed indicator type.
	 * 
	 * @param serviceIndicator serviceIndicator of desired service
	 * @return IValidationService
	 */
	@Override
	public IValidationService<?> getCalculatorValidatorService(String serviceIndicator) {
		return mapOfValidatorObjects.get(serviceIndicator);
	}

	@Override
	public ICalculatorService getCalculatorService(String serviceIndicator) {
		return null;
	}

}