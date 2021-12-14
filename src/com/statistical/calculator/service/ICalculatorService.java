package com.statistical.calculator.service;
/**
 * Service to perform calculation based on calculator type
 * @param <T>
 */
public interface ICalculatorService<T>{
    void compute(T t);
}
