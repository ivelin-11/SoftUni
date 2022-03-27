package com.softuni.productshop.services;


import com.softuni.productshop.entities.categories.ExportCategoryInfo;
import com.softuni.productshop.entities.products.ExportProductInRangeRootDTO;

public interface ProductService {

    ExportProductInRangeRootDTO getProductsInPriceRange(int lower, int higher);


    ExportCategoryInfo getProductsStatsByCategories();
}
