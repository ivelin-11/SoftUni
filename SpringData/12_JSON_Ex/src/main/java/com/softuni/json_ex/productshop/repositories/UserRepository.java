package com.softuni.json_ex.productshop.repositories;

import com.softuni.json_ex.productshop.entities.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {


    @Query("SELECT u " +
            "FROM User u " +
            "WHERE u.soldProducts.size >0 " +
            "ORDER BY u.lastName ASC, u.firstName ASC ")
    List<User> findUsersWithSoldProductsAndBuyers();


    @Query("SELECT u " +
            "FROM User u " +
            "JOIN u.soldProducts "+
            "WHERE u.soldProducts.size >= 1 " +
            "ORDER BY u.soldProducts.size DESC ")
    List<User> findUsersAndSoldProducts();
}
