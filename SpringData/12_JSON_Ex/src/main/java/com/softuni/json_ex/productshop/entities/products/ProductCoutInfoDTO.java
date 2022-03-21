package com.softuni.json_ex.productshop.entities.products;

import java.util.List;

public class ProductCoutInfoDTO {

    private  int count;

   List<ProductInfoDTO> products;

    public ProductCoutInfoDTO() {

    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<ProductInfoDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductInfoDTO> products) {
        this.products = products;
    }
}
