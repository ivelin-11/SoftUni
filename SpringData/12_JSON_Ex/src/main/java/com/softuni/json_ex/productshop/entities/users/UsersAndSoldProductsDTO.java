package com.softuni.json_ex.productshop.entities.users;

import java.util.List;

public class UsersAndSoldProductsDTO {

    private final long usersCount;

    private List<UserInfoDTO> users;

    public UsersAndSoldProductsDTO(long usersCount) {
        this.usersCount = usersCount;
    }

    public void setUsers(List<UserInfoDTO> users) {
        this.users = users;
    }
}
