package com.softuni.json_ex.car_dealer.services;

import java.io.FileNotFoundException;

public interface Seeder {

    void seedSuppliers() throws FileNotFoundException;

    void seedParts() throws FileNotFoundException;

    void seedCars() throws FileNotFoundException;

    void seedCustomers() throws FileNotFoundException;

    void seedSales();

    default void seedAll() throws FileNotFoundException {
        seedSuppliers();
        seedParts();
        seedCars();
        seedCustomers();
        seedSales();
    }
}
