package com.statistical.calculator.dto;

/**
 * Request object to hold statistic input data
 * Follows builder design pattern
 */
public class StatisticRequestDTO{
	private double input;
	private int inLastNminutes;
	
	public StatisticRequestDTO(StatisticRequestDTOBuilder statisticRequestDTOBuilder) {
		this.input=statisticRequestDTOBuilder.input;
		this.inLastNminutes=statisticRequestDTOBuilder.inLastNminutes;
	}
		
	public double getInput() {
		return input;
	}

	public int getInLastNminutes() {
		return inLastNminutes;
	}

	public static StatisticRequestDTOBuilder toBuilder() {
		return new StatisticRequestDTOBuilder();
	}
	
	public static class StatisticRequestDTOBuilder{
		private double input;
		private int inLastNminutes;
		
		public StatisticRequestDTOBuilder input(double input) {
			this.input = input;
			return this;
		}
		
		public StatisticRequestDTOBuilder inLastNminutes(int inLastNminutes) {
			this.inLastNminutes = inLastNminutes;
			return this;
		}
		
		public StatisticRequestDTO build() {
			return new StatisticRequestDTO(this);
		}	
	}
}
