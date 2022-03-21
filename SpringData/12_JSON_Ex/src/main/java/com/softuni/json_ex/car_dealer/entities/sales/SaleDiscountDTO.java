package com.softuni.json_ex.car_dealer.entities.sales;

import com.softuni.json_ex.car_dealer.entities.cars.CarBasicInfoDTO;

import java.math.BigDecimal;

public class SaleDiscountDTO {

    private CarBasicInfoDTO car;

    private String customerName;

    private double Discount;

    private BigDecimal price;

    private BigDecimal priceWithDiscount;




    public CarBasicInfoDTO getCar() {
        return car;
    }

    public void setCar(CarBasicInfoDTO car) {
        this.car = car;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getDiscount() {
        return Discount;
    }

    public void setDiscount(double discount) {
        Discount = discount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPriceWithDiscount() {
        return priceWithDiscount;
    }

    public void setPriceWithDiscount(BigDecimal priceWithDiscount) {
        this.priceWithDiscount = priceWithDiscount;
    }
}
