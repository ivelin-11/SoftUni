package com.softuni.json_ex.productshop.entities.products;

import java.math.BigDecimal;

public class ProductInfoDTO {

    private String name;

    private BigDecimal price;


    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
