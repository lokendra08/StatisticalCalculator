package com.statistical.calculator.util;

import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Utility service to provide general purpose methods
 */
public class CalcUtility {

	/**
	 * checks if given entry is older than N minutes or not
	 * 
	 * @param inLastNMinutes      time in minutes
	 * @param entry            contains entry and insertion time in millis.
	 * @return boolean
	 */
	public static boolean checkIfLastNMinutes(int inLastNMinutes, Map.Entry<Double, Long> entry) {
		long currentTimestamp = System.currentTimeMillis();
		long searchTimestamp = entry.getValue();
		long difference = Math.abs(currentTimestamp - searchTimestamp);
		if (difference > inLastNMinutes * 60 * 1000) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Returns the mean of received sample values.
	 * 
	 * @param sum      total sum of the entries
	 * @param count    total count of the entries.
	 * @return double
	 */
	public static double getMean(double sum, int count) {
		return sum / count;
	}

	/**
	 * Returns an estimate of the variance of the total population given the received
     * sample values.
     * 
	 * @param sum      total sum of the entries
	 * @param count    total count of the entries.
	 * @param entry            contains entry and insertion time in millis.
	 * @return double
	 */
	public static double getVariance(double sum, int count, IdentityHashMap<Double, Long> entryTimeMap) {
		double mean = getMean(sum, count);
		double totalSum = 0;
		List<Double> data = entryTimeMap.keySet().stream().collect(Collectors.toList());
		for (Double a : data) {
			totalSum += (a - mean) * (a - mean);
		}
		return totalSum / (count - 1);
	}

}
