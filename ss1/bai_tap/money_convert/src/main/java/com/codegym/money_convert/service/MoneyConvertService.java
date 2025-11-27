package com.codegym.money_convert.service;

import com.codegym.money_convert.repository.IMoneyConvertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoneyConvertService implements IMoneyConvertService {
    @Autowired
    private IMoneyConvertRepository moneyConvertRepository;

    @Override
    public Double USDToVND(Double USD) {
        return moneyConvertRepository.USDToVND(USD);
    }

    @Override
    public Double VNDToUSD(Double VND) {
        return moneyConvertRepository.VNDToUSD(VND);
    }
}
