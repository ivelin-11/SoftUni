package com.softuni.json_ex.productshop.services;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface SeedService {

    void seedUsers() throws FileNotFoundException;

    void seedCategories() throws IOException;

    void seedProducts() throws FileNotFoundException;

    default void seedAll() throws IOException {
        seedUsers();
        seedCategories();
        seedProducts();
    }
}
