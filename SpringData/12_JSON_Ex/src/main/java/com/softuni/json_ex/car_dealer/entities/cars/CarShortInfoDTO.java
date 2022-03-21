package com.softuni.json_ex.car_dealer.entities.cars;

public class CarShortInfoDTO {

    private String Make;


    private String Model;

    private long TravelledDistance;



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
