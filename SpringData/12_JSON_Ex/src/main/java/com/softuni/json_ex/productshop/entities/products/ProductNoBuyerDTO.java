package com.softuni.json_ex.productshop.entities.products;

import java.math.BigDecimal;

public class ProductNoBuyerDTO {

    private String name;

    private BigDecimal price;

    private String sellerFullName;

    public ProductNoBuyerDTO(String name, BigDecimal price, String sellerFirstName, String sellerLastName) {
        this.name = name;
        this.price = price;
       setFullName(sellerFirstName,sellerLastName);
    }

    private void setFullName(String sellerFirstName, String sellerLastName) {
        if (sellerFirstName==null) {
            this.sellerFullName = sellerLastName;
            return;
        }
        if (sellerLastName==null) {
            this.sellerFullName = sellerFirstName;
            return;
        }

        this.sellerFullName = sellerFirstName + " " + sellerLastName;
    }
}
