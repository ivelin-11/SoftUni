package com.softuni.json_ex.car_dealer.services;

import com.softuni.json_ex.car_dealer.entities.customers.CustomerInfoDTO;
import com.softuni.json_ex.car_dealer.entities.customers.CustomerSummaryDTO;

import java.util.List;

public interface CustomerService {
    List<CustomerInfoDTO> getOrderedCustomers();

    List<CustomerSummaryDTO> getSalesByCustomer();
}
