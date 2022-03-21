package com.softuni.json_ex.car_dealer.entities.customers;


import java.time.LocalDateTime;

public class CustomerImportDTO {

    private String name;

    private String birthDate;

    private boolean isYoungDriver;


    public CustomerImportDTO(){

    }

    public String getName() {
        return name;
    }

    public  String getBirthDate() {
        return birthDate;
    }

    public boolean isYoungDriver() {
        return isYoungDriver;
    }
}
