package com.codegym.calculator.repositories;

import org.springframework.stereotype.Repository;

@Repository
public class CalculatorRepository implements ICalculatorRepository {
    @Override
    public Double calculate(Double firstOperand, Double secondOperand, char operator) {
        switch (operator) {
            case '+':
                return firstOperand + secondOperand;
            case '-':
                return firstOperand - secondOperand;
            case '*':
                return firstOperand * secondOperand;
            case '/':
                return firstOperand / secondOperand;
        }
        return 0.0;
    }
}
