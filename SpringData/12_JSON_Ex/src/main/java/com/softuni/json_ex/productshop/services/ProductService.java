package com.softuni.json_ex.productshop.services;

import com.softuni.json_ex.productshop.entities.categories.CategoryStatsDTO;
import com.softuni.json_ex.productshop.entities.products.ProductNoBuyerDTO;

import java.util.List;

public interface ProductService {
    List<ProductNoBuyerDTO> findProductsWithPriceInRangeAndNoBuyer(int lower, int upper);

    List<CategoryStatsDTO> getCategoriesStatistics();
}
