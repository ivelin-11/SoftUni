package com.softuni.json_ex.productshop.entities.users;

import java.math.BigDecimal;

public class UserImportDTO {

    private String firstName;

    private String lastName;

    private BigDecimal age;

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

    public BigDecimal getAge() {
        return age;
    }

    public void setAge(BigDecimal age) {
        this.age = age;
    }
}
