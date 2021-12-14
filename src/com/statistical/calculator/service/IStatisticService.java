package com.statistical.calculator.service;

/**
 * Service to perform statistical calculation
 *
 */
public interface IStatisticService {
	
		/**
		 * Called to update the statistic with a new sample value.
		 * 
		 * @param num             input from user
		 * @return void
		 */
	     void event(double num);
	     
	 
		/**
		 * Returns the mean of received sample values.
		 * return object from object factory based on runtime service type.
         *
		 * @return double
		 */	 
	     double getMean();
	     
	     
		/**
		 * Returns the mean of sample values received in last N minutes only.
		 * 
		 * @param inLastNminutes             time in minutes
		 * @return double
		 */
	     double getMean(int inLastNminutes);
	     
	     
		/**
		 * Returns an estimate of the variance of the total population given the received
         * sample values.
		 * 
		 * @return double
		 */
	     double getVariance();
	     
	     
		/**
		 * Returns minimum number.
		 * 
		 * @return double
		 */
	     double getMin();
	     
	     
		/**
		 * Returns maximum number.
		 * 
		 * @return double
		 */
	     double getMax();
}
