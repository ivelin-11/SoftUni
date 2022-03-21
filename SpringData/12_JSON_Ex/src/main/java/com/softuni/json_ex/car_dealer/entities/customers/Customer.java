package com.softuni.json_ex.car_dealer.entities.customers;


import com.softuni.json_ex.car_dealer.entities.sales.Sale;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String name;

    @NotNull
    private LocalDateTime birthDate;

    @NotNull
    @Column(name = "is_young_driver")
    private boolean isYoungDriver;

    @OneToMany(mappedBy = "customer",targetEntity = Sale.class)
   private Set<Sale> boughtCars;


    public Customer(){

    }
    public Customer(String name, LocalDateTime birthDate, boolean isYoungDriver) {
        this.name = name;
        this.birthDate = birthDate;
        this.isYoungDriver = isYoungDriver;
        this.boughtCars=new HashSet<>();
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isYoungDriver() {
        return isYoungDriver;
    }

    public void setYoungDriver(boolean youngDriver) {
        isYoungDriver = youngDriver;
    }

    public Set<Sale> getBoughtCars() {
        return boughtCars;
    }

    public void setBoughtCars(Set<Sale> boughtCars) {
        this.boughtCars = boughtCars;
    }
}
