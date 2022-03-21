package com.softuni.json_ex.car_dealer.repositories;

import com.softuni.json_ex.car_dealer.entities.suppliers.Supplier;
import com.softuni.json_ex.car_dealer.entities.suppliers.SupplierLocalSoldPartsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SupplierRepository extends JpaRepository<Supplier,Long> {

    @Query("SELECT new com.softuni.json_ex.car_dealer.entities.suppliers.SupplierLocalSoldPartsDTO( " +
            "s.id, s.name, s.parts.size) " +
            "FROM Supplier s "+
    "WHERE s.isImporter = FALSE")
    List<SupplierLocalSoldPartsDTO> getSupplierNameAndCountSoldParts();
}
