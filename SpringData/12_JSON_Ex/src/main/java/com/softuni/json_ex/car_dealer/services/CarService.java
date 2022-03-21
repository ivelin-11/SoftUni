package com.softuni.json_ex.car_dealer.services;

import com.softuni.json_ex.car_dealer.entities.cars.CarInfoDTO;
import com.softuni.json_ex.car_dealer.entities.cars.CarPartsDTO;

import java.util.List;

public interface CarService {
    List<CarInfoDTO> getCarsByBrandToyota();

    List<CarPartsDTO> getCarsWithTheirParts();
}
