package com.softuni.json_ex.productshop.repositories;


import com.softuni.json_ex.productshop.entities.categories.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
}
