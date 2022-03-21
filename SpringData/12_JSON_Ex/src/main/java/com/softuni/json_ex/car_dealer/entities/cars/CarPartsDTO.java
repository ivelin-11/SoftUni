package com.softuni.json_ex.car_dealer.entities.cars;

import com.softuni.json_ex.car_dealer.entities.parts.PartInfoDTO;

import java.util.List;

public class CarPartsDTO {

    CarShortInfoDTO car;

    List<PartInfoDTO> parts;

    public void setCar(CarShortInfoDTO car) {
        this.car = car;
    }

    public void setParts(List<PartInfoDTO> parts) {
        this.parts = parts;
    }
}
