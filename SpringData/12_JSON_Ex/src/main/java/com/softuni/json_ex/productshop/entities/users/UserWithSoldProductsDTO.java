package com.softuni.json_ex.productshop.entities.users;

import com.softuni.json_ex.productshop.entities.products.SoldProductsDTO;

import java.util.HashSet;
import java.util.Set;

public class UserWithSoldProductsDTO {

    private String firstName;

    private String lastName;

    private Set<SoldProductsDTO> soldProducts;

    public UserWithSoldProductsDTO(){
        this.soldProducts=new HashSet<>();
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSoldProducts(Set<SoldProductsDTO> soldProducts) {
        this.soldProducts = soldProducts;
    }
}
