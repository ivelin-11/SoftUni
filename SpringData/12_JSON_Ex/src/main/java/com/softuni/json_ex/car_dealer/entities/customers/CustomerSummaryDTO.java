package com.softuni.json_ex.car_dealer.entities.customers;

import java.math.BigDecimal;

public class CustomerSummaryDTO {

    private String fullName;

    private int boughtCars;

    private BigDecimal spentMoney;

    public CustomerSummaryDTO(String fullName, int boughtCars, BigDecimal spentMoney) {
        this.fullName = fullName;
        this.boughtCars = boughtCars;
        this.spentMoney = spentMoney;
    }

    public void setSpentMoney(BigDecimal spentMoney) {
        this.spentMoney = spentMoney;
    }

    public String getFullName() {
        return fullName;
    }

    public int getBoughtCars() {
        return boughtCars;
    }

    public BigDecimal getSpentMoney() {
        return spentMoney;
    }
}
