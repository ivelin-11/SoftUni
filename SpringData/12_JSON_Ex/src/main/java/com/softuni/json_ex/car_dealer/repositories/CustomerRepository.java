package com.softuni.json_ex.car_dealer.repositories;

import com.softuni.json_ex.car_dealer.entities.customers.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
