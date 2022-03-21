package com.softuni.json_ex.car_dealer.services;

import com.softuni.json_ex.car_dealer.entities.suppliers.SupplierLocalSoldPartsDTO;

import java.util.List;

public interface SupplierService {

    List<SupplierLocalSoldPartsDTO> getLocalSuppliersSoldPartsCount();
}
