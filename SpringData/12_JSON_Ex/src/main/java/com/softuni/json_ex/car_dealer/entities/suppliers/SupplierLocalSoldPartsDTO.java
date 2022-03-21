package com.softuni.json_ex.car_dealer.entities.suppliers;

import javax.validation.constraints.NotNull;

public class SupplierLocalSoldPartsDTO {

    private long Id;

    private String Name;

    int  partsCount;

    public SupplierLocalSoldPartsDTO(long id, String name, int partsCount) {
        Id = id;
        Name = name;
        this.partsCount = partsCount;
    }
}
