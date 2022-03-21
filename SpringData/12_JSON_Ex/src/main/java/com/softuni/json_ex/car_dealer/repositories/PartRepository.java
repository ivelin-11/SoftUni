package com.softuni.json_ex.car_dealer.repositories;

import com.softuni.json_ex.car_dealer.entities.parts.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PartRepository extends JpaRepository<Part,Long> {
}
