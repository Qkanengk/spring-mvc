package com.codegym.money_convert.entity;

public class MoneyConvert {
    private Double USD;
    private Double VND;

    public MoneyConvert() {
    }

    public MoneyConvert(Double USD, Double VND) {
        this.USD = USD;
        this.VND = VND;
    }

    public Double getUSD() {
        return USD;
    }

    public void setUSD(Double USD) {
        this.USD = USD;
    }

    public Double getVND() {
        return VND;
    }

    public void setVND(Double VND) {
        this.VND = VND;
    }
}
