package com.softuni.json_ex.car_dealer.services;


import com.softuni.json_ex.car_dealer.entities.sales.SaleDiscountDTO;

import java.util.List;

public interface SaleService {
    public List<SaleDiscountDTO> getSalesWithAppliedDiscount();
}
