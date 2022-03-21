package com.softuni.json_ex.car_dealer.entities.cars;

import javax.validation.constraints.NotNull;

public class CarImportDTO {


    private String make;


    private String model;

    private long travelledDistance;

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public long getTravelledDistance() {
        return travelledDistance;
    }
}
