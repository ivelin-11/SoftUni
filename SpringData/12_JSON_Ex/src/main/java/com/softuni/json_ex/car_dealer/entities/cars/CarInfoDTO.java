package com.softuni.json_ex.car_dealer.entities.cars;

import javax.validation.constraints.NotNull;

public class CarInfoDTO {

    private long Id;

    private String Make;


    private String Model;

    private long TravelledDistance;

    public void setId(long id) {
        Id = id;
    }

    public void setMake(String make) {
        Make = make;
    }

    public void setModel(String model) {
        Model = model;
    }

    public void setTravelledDistance(long travelledDistance) {
        TravelledDistance = travelledDistance;
    }
}
