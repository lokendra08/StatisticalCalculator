package com.statistical.calculator.objectfactory;

import java.util.HashMap;
import java.util.Map;
import com.statistical.calculator.constant.CalculatorConstants;

/**
 * handles object creation (factory of factory).
 *  This is factory of factory for ICalculatorService
 */
public class ObjectCreationFactory {
	
	static Map<String , AbstractFactory> mapOfFactoryObjects = new HashMap<String, AbstractFactory>(){
		{
			put(CalculatorConstants.CALCULATOR_SERVICE, new CalculatorServiceFactory());
			put(CalculatorConstants.CALCULATOR_VALIDATOR_SERVICE, new CalculatorValidatorServiceFactory());
		}
	};

	/**
	 * Returns an object which represent factory of CalculatorService based on passed parameter.
	 * @param indicator indicator indication type of factory
	 * @return AbstractFactory
	 */
	public static AbstractFactory getObjectfactory(String FactoryServiceIndicator) {
		return mapOfFactoryObjects.get(FactoryServiceIndicator);
	}

}
