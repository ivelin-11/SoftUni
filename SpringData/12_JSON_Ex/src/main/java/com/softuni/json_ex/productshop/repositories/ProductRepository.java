package com.softuni.json_ex.productshop.repositories;

import com.softuni.json_ex.productshop.entities.categories.CategoryStatsDTO;
import com.softuni.json_ex.productshop.entities.products.Product;
import com.softuni.json_ex.productshop.entities.products.ProductNoBuyerDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

;
import java.math.BigDecimal;
import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    @Query("SELECT new com.softuni.json_ex.productshop.entities.products.ProductNoBuyerDTO(" +
            "p.name, p.price, p.seller.firstName, p.seller.lastName) " +
            "FROM Product p " +
            "WHERE p.price > :min AND p.price < :max AND p.buyer IS NULL " +
            "ORDER BY p.price ASC")
    List<ProductNoBuyerDTO> findProductsWithPriceInRangeAndNoBuyer(@Param("min") BigDecimal min , BigDecimal max);


    @Query("SELECT new com.softuni.json_ex.productshop.entities.categories.CategoryStatsDTO( "+
             "c.name, COUNT(p) , AVG(p.price), SUM(p.price)) "+
             "FROM Product p "+
             "JOIN p.categories c "+
             "GROUP BY c")
    List<CategoryStatsDTO> getCategoryStats();
}
