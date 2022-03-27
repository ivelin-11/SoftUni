package com.softuni.productshop.repositories;


import com.softuni.productshop.entities.categories.CategoryStatsDTO;
import com.softuni.productshop.entities.products.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.math.BigDecimal;
import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    List<Product> findAllByPriceBetweenAndBuyerIsNotNullOrderByPriceAsc(BigDecimal lowerBound, BigDecimal upperBound);


    @Query("SELECT new com.softuni.productshop.entities.categories.CategoryStatsDTO( " +
            "c.name, COUNT(p), AVG(p.price), SUM(p.price) )" +
            "FROM Product p " +
            "JOIN p.categories c " +
            "GROUP BY c ")
    List<CategoryStatsDTO> getCategoriesStats();
}
