package com.codegym.calculator.repositories;

public interface ICalculatorRepository {
    Double calculate(Double firstOperand, Double secondOperand, char operator);
}
