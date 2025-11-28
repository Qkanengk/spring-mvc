package com.codegym.calculator.services;

import com.codegym.calculator.repositories.ICalculatorRepository;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {
    private final ICalculatorRepository calculatorRepository;
    public CalculatorService(ICalculatorRepository calculatorRepository) {
        this.calculatorRepository = calculatorRepository;
    }

    @Override
    public Double calculate(Double firstOperand, Double secondOperand, char operator) {
        return calculatorRepository.calculate( firstOperand, secondOperand, operator);
    }
}
