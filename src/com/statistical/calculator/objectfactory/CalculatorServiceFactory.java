package com.statistical.calculator.objectfactory;

import java.util.HashMap;
import java.util.Map;
import com.statistical.calculator.constant.CalculatorConstants;
import com.statistical.calculator.service.ICalculatorService;
import com.statistical.calculator.service.impl.ScientificCalculatorService;
import com.statistical.calculator.service.impl.StandardCalculatorService;
import com.statistical.calculator.service.impl.StatisticalCalculatorService;
import com.statistical.calculator.validation.IValidationService;

/**
 * handles object creation This is factory of classes implementing
 * ICalculationService.
 */
public class CalculatorServiceFactory extends AbstractFactory {
	
	static Map<String , ICalculatorService> mapOfObjects = new HashMap<String, ICalculatorService>(){
		{
			put(CalculatorConstants.STATISTICAL,new StatisticalCalculatorService());
			put(CalculatorConstants.SCIENTIFIC,new ScientificCalculatorService());
			put(CalculatorConstants.STANDARD,new StandardCalculatorService());
		}
	};
	
    
	/**
	 * return desired object based on passed indicator type.
	 * @param serviceIndicator  serviceIndicator of desired service
	 * @return ICalculatorService
	 */
	@Override
	public ICalculatorService<?> getCalculatorService(String serviceIndicator) {
		return mapOfObjects.get(serviceIndicator);
	}



	@Override
	public IValidationService<?> getCalculatorValidatorService(String serviceIndicator) {
		return null;
	}

}
