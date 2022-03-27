package com.softuni.productshop.services;


import com.softuni.productshop.entities.users.ExportSellersDTO;
import com.softuni.productshop.entities.users.ExportUserSummary;

public interface UserService {

    ExportSellersDTO getUsersWithSoldProducts();

    ExportUserSummary getUsersAndSoldProducts();
}
