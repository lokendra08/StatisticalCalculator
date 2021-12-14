package com.statistical.calculator.exception;

/**
 * Exception class to hold validation related exceptions
 */
public class CalculatorValidatorException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs an CalculatorValidatorException with no detail message.
	 */
	public CalculatorValidatorException() {
	}

	/**
	 * Constructs an CalculatorValidatorException with the specified detail message.
	 *
	 * @param message the detail message
	 */
	public CalculatorValidatorException(String message) {
		super(message);
	}

}