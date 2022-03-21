package com.softuni.json_ex.productshop.entities.categories;

import java.math.BigDecimal;

public class CategoryStatsDTO {

    private String name;

    private long productsCount;

    private  double averagePrice;

    private BigDecimal totalRevenue;

    public CategoryStatsDTO(String name, long productsCount, double averagePrice, BigDecimal totalRevenue) {
        this.name = name;
        this.productsCount = productsCount;
        this.averagePrice = averagePrice;
        this.totalRevenue = totalRevenue;
    }
}
