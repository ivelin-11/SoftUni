package com.softuni.json_ex.car_dealer.services;

import com.softuni.json_ex.car_dealer.repositories.SupplierRepository;
import com.softuni.json_ex.car_dealer.entities.suppliers.SupplierLocalSoldPartsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public List<SupplierLocalSoldPartsDTO> getLocalSuppliersSoldPartsCount(){

        List<SupplierLocalSoldPartsDTO> suppliers = this.supplierRepository.getSupplierNameAndCountSoldParts();

        return suppliers;
    }
}
