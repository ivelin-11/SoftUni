package com.softuni.json_ex.productshop.entities.products;

import java.math.BigDecimal;

public class SoldProductsDTO {

    private String name;

    private BigDecimal price;

    private String buyerFirstName;

    private String buyerLastName;


    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setBuyerFirstName(String buyerFirstName) {
        this.buyerFirstName = buyerFirstName;
    }

    public void setBuyerLastName(String buyerLastName) {
        this.buyerLastName = buyerLastName;
    }
}
