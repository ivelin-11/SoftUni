package com.softuni.json_ex.productshop.services;

import com.softuni.json_ex.productshop.entities.users.UserWithSoldProductsDTO;
import com.softuni.json_ex.productshop.entities.users.UsersAndSoldProductsDTO;

import java.util.List;

public interface UserService {
    List<UserWithSoldProductsDTO> getUsersWithSoldProducts();

    UsersAndSoldProductsDTO getUsersAndSoldProducts();
}
