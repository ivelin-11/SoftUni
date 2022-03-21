package com.softuni.json_ex.car_dealer.entities.customers;

import com.softuni.json_ex.car_dealer.entities.sales.Sale;

import java.util.Set;

public class CustomerInfoDTO {


    private long Id;


    private String Name;


    private String birthDate;


    private boolean IsYoungDriver;

    private Set<Sale> BoughtCars;


    public void setId(long id) {
        this.Id = id;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setYoungDriver(boolean youngDriver) {
        IsYoungDriver = youngDriver;
    }
}
