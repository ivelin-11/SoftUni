package com.softuni.json_ex.productshop.entities.users;

import com.softuni.json_ex.productshop.entities.products.ProductCoutInfoDTO;

public class UserInfoDTO {

    private String firstName;

    private String lastName;

    private int age;

    ProductCoutInfoDTO soldProducts;


    public UserInfoDTO() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public ProductCoutInfoDTO getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(ProductCoutInfoDTO soldProducts) {
        this.soldProducts = soldProducts;
    }
}
