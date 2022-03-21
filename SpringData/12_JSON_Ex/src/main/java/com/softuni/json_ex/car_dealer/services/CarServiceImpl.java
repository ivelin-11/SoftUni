package com.softuni.json_ex.car_dealer.services;


import com.softuni.json_ex.car_dealer.entities.cars.CarInfoDTO;
import com.softuni.json_ex.car_dealer.entities.cars.Car;
import com.softuni.json_ex.car_dealer.entities.cars.CarPartsDTO;
import com.softuni.json_ex.car_dealer.entities.cars.CarShortInfoDTO;
import com.softuni.json_ex.car_dealer.entities.parts.PartInfoDTO;
import com.softuni.json_ex.car_dealer.repositories.CarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final ModelMapper modelMapper;
    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
        this.modelMapper=new ModelMapper();
    }


    @Override
    public List<CarInfoDTO> getCarsByBrandToyota() {
        List<Car> cars = this.carRepository.getCarsByBrandOrderByModelAscAndTravelledDesc();

        List<CarInfoDTO> carInfoDTOS = cars.stream().map(c -> this.modelMapper.map(c, CarInfoDTO.class)).collect(Collectors.toList());
        return carInfoDTOS;
    }

    @Transactional
    @Override
    public List<CarPartsDTO> getCarsWithTheirParts() {

        Set<Car> carsAndTheirParts = this.carRepository.getCarsAndParts();

        List<CarPartsDTO> carPartsDTOS=new ArrayList<>();

        carsAndTheirParts.stream().forEach(c->{

            CarPartsDTO carPartsDTO=new CarPartsDTO();

            CarShortInfoDTO carShortInfoDTO = this.modelMapper.map(c, CarShortInfoDTO.class);
            carPartsDTO.setCar(carShortInfoDTO);

            List<PartInfoDTO> partInfoDTOS = c.getParts().stream().
                    map(p -> this.modelMapper.map(p, PartInfoDTO.class)).collect(Collectors.toList());

        carPartsDTO.setParts(partInfoDTOS);

        carPartsDTOS.add(carPartsDTO);
        });

        return carPartsDTOS;
    }
}
