package com.codegym.money_convert.repository;

import org.springframework.stereotype.Repository;

@Repository
public class MoneyConvertRepository implements IMoneyConvertRepository {
    @Override
    public Double USDToVND(Double USD) {
        return USD * 26000;
    }

    @Override
    public Double VNDToUSD(Double VND) {
        return VND/26000;
    }
}
