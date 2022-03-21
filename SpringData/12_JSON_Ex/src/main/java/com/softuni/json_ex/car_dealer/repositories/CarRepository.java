package com.softuni.json_ex.car_dealer.repositories;

import com.softuni.json_ex.car_dealer.entities.cars.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;


@Repository
public interface CarRepository extends JpaRepository<Car,Long> {

    @Query("SELECT c FROM Car c "+
    "WHERE c.make = 'Toyota' "+
    "ORDER BY c.model ASC, c.travelledDistance DESC")
    List<Car> getCarsByBrandOrderByModelAscAndTravelledDesc();

    @Query("SELECT c FROM Car c "+
            "JOIN c.parts")
    Set<Car> getCarsAndParts();
}
