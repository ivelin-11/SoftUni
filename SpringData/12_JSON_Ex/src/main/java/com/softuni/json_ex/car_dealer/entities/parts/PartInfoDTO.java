package com.softuni.json_ex.car_dealer.entities.parts;


import java.math.BigDecimal;

public class PartInfoDTO {


    private String Name;


    private BigDecimal Price;

    public void setName(String name) {
        this.Name = name;
    }

    public void setPrice(BigDecimal price) {
        this.Price = price;
    }
}
