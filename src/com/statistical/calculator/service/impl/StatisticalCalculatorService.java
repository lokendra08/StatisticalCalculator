package com.statistical.calculator.service.impl;

import java.util.Date;
import java.util.IdentityHashMap;
import com.statistical.calculator.constant.CalculatorConstants;
import com.statistical.calculator.dto.StatisticRequestDTO;
import com.statistical.calculator.service.ICalculatorService;
import com.statistical.calculator.service.IStatisticService;
import com.statistical.calculator.util.CalcUtility;

/**
 * Implementation class to perform statistical calculation
 */
public class StatisticalCalculatorService implements IStatisticService, ICalculatorService<StatisticRequestDTO> {
	private int entriesCount;
	private double sum;
	private double maximum = Double.NEGATIVE_INFINITY;
	private double minimum = Double.POSITIVE_INFINITY;
	private IdentityHashMap<Double, Long> entryTimeMap = new IdentityHashMap<Double, Long>();
    
	/**
	 * computes statistical calculation on incoming entries
	 * 
	 * @param statisticRequestDTO      request object holding entries
	 * @return void
	 */
	@Override
	public void compute(StatisticRequestDTO statisticRequestDTO) {
		this.event(statisticRequestDTO.getInput());
		this.displayStatistics();
	}

	/**
	 * Called to update the statistic with a new sample value.
	 * updates internal data hold size, total sum, maximum and minimum values.
	 * 
	 * @param num             input from user
	 * @return void
	 */	
	@Override
	public void event(double num) {
		entryTimeMap.put(num, System.currentTimeMillis());
		entriesCount++;
		sum += num;
		if (num > maximum)
			maximum = num;
		if (num < minimum)
			minimum = num;
	}

	/**
	 * Returns the mean of received sample values..
	 * return object from object factory based on runtime service type.
     *
	 * @return double
	 */
	@Override
	public double getMean() {
		return CalcUtility.getMean(getSum(), getCount());
	}

	/**
	 * Returns the mean of sample values received in last N minutes only.
	 * 
	 * @param inLastNminutes             time in minutes
	 * @return double
	 */
	@Override
	public double getMean(int inLastNminutes) {
		IdentityHashMap<Double, Long> map = new IdentityHashMap<Double, Long>();
        entryTimeMap.entrySet().parallelStream().filter(entry->CalcUtility.checkIfLastNMinutes(inLastNminutes, entry)).forEach(e->{
        	map.put(e.getKey(), e.getValue());
		});
        map.entrySet().stream().forEach(entry->{
        	System.out.println(entry.getKey()+"  :  "+entry.getValue()+"  :  "+new Date(entry.getValue()));
        });     
		return CalcUtility.getMean(map.keySet().stream().mapToDouble(key->key).sum(), map.size());
	}

	/**
	 * Returns an estimate of the variance of the total population given the received
     * sample values.
	 * 
	 * @return double
	 */
	@Override
	public double getVariance() {
		return CalcUtility.getVariance(sum, entriesCount, entryTimeMap);
	}

	/**
	 * Returns minimum number.
	 * 
	 * @return double
	 */
	@Override
	public double getMin() {
		return minimum;
	}

	/**
	 * Returns maximum number.
	 * 
	 * @return double
	 */
	@Override
	public double getMax() {
		return maximum;
	}

	/**
	 * Returns total number of entries.
	 * 
	 * @return int
	 */
	public int getCount() {
		return entriesCount;
	}

	/**
	 * Returns total sum of the entries.
	 * 
	 * @return double
	 */
	public double getSum() {
		return sum;
	}
	
	
	/**
	 * Display minimum, maximum, mean, variance and total entries.
	 * 
	 * @return void
	 */
	public void displayStatistics() {
		System.out.println("\nStatistics Details:\n");
		System.out.println("   Total Entries:   " + this.getCount());
		System.out.println("   Minimum:         " + this.getMin());
		System.out.println("   Maximum:         " + this.getMax());
		System.out.println("   Mean:            " + this.getMean());
		if (getCount() == 1) {
			System.out.println("   Variance:        " + "NA");
		} else {
			System.out.println("   Variance:        " + this.getVariance());
		}
		System.out.println("Mean of entries in last "+CalculatorConstants.IN_LAST_N_MINUTES+" minutes  "+ this.getMean(CalculatorConstants.IN_LAST_N_MINUTES));
	}
}
