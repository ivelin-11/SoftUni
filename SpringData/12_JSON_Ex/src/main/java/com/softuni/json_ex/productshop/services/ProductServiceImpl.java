package com.softuni.json_ex.productshop.services;

import com.softuni.json_ex.productshop.entities.categories.CategoryStatsDTO;
import com.softuni.json_ex.productshop.entities.products.ProductNoBuyerDTO;
import com.softuni.json_ex.productshop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;


    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    @Transactional
    public List<ProductNoBuyerDTO> findProductsWithPriceInRangeAndNoBuyer(int lower, int upper) {

        BigDecimal min = BigDecimal.valueOf(lower);
        BigDecimal max = BigDecimal.valueOf(upper);

       return this.productRepository.findProductsWithPriceInRangeAndNoBuyer(min, max);



    }

    @Override
    public List<CategoryStatsDTO> getCategoriesStatistics() {
        List<CategoryStatsDTO> categoryStats = this.productRepository.getCategoryStats();

        return  categoryStats;
    }
}
