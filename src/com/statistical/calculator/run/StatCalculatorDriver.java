package com.statistical.calculator.run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import com.statistical.calculator.constant.CalculatorConstants;
import com.statistical.calculator.dto.StatisticRequestDTO;
import com.statistical.calculator.exception.CalculatorValidatorException;
import com.statistical.calculator.objectfactory.ObjectCreationFactory;
import com.statistical.calculator.service.ICalculatorService;
import com.statistical.calculator.validation.IValidationService;

/*
 * Driver class for calculation
 */
public class StatCalculatorDriver {
	
	private Lock lock = new ReentrantLock(true);
	
	/**
	 * Takes user input from console as an string and invoke calculator service.
	 * @return void
	 * @exception CalculatorValidatorException, IOException
	 */
	public void run() {
		String item;
		System.out.println("1: Enter your numbers.");
		System.out.println(" ");
		lock.lock();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			do {
				item = reader.readLine();
				if (!item.equals("0")) {
					try {
						validateRequest(item);
						invokeCalulation(item);
					} catch (CalculatorValidatorException ex) {
						System.out.println(ex.getMessage());
					}
				} else {
					System.exit(0);
				}
				System.out.println("continue to enter number OR enter 0 to exit");
			} while (true);

		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}

	/**
	 * Invokes validation service based on service implementation.
	 * @param input             user input 
	 * @return void
	 * @exception CalculatorValidatorException
	 */
	private static void validateRequest(String input) throws CalculatorValidatorException {
		IValidationService validationService = ObjectCreationFactory
				.getObjectfactory(CalculatorConstants.CALCULATOR_VALIDATOR_SERVICE)
				.getCalculatorValidatorService(CalculatorConstants.STATISTICAL_REQUEST_VALIDATION);
		validationService.validateRequest(input);

	}

	/**
	 * Invokes calculator service based on service implementation.
	 * 
	 * @param input             request object to wrap user input
	 * @return void
	 * @exception CalculatorValidatorException
	 */
	private static void invokeCalulation(String item) throws CalculatorValidatorException {
		ICalculatorService calulationService = ObjectCreationFactory
				.getObjectfactory(CalculatorConstants.CALCULATOR_SERVICE)
				.getCalculatorService(CalculatorConstants.STATISTICAL);
		StatisticRequestDTO requestObject = StatisticRequestDTO.toBuilder()
				                                               .input(Double.parseDouble(item))
				                                               .build();
		calulationService.compute(requestObject);
	}

}
