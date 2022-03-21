package com.softuni.json_ex.car_dealer.repositories;

import com.softuni.json_ex.car_dealer.entities.customers.Customer;
import com.softuni.json_ex.car_dealer.entities.customers.CustomerSummaryDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT c FROM Customer c " +
            " ORDER BY c.birthDate ASC, c.isYoungDriver DESC")
    List<Customer> findAllOrderByBirthDateAscAndIsYoungDriverDesc();

    @Query("SELECT c " +
            "FROM Customer c " +
            "JOIN c.boughtCars " +
            "WHERE c.boughtCars.size>0 " +
            "GROUP BY c")
    List<Customer> getCustomersSalesCarsCount();
}
