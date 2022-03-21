package com.softuni.json_ex.productshop.entities.users;


import com.softuni.json_ex.productshop.entities.products.Product;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;


    @Column(name = "last_name")
    @NotNull
    @Size(min = 3)
    private String lastName;

    private Integer age;


    @ManyToMany
    @JoinTable(name ="users_friends",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id", referencedColumnName = "id")
    )
    private Set<User> friends;


    @OneToMany(mappedBy = "seller",targetEntity = Product.class)
    private Set<Product> soldProducts;

    @OneToMany(mappedBy = "buyer",targetEntity = Product.class)
    private Set<Product> boughtProducts;

    public User(String firstName, String lastName, Integer age) {
        this.friends=new HashSet<>();
        this.boughtProducts=new HashSet<>();
        this.soldProducts=new HashSet<>();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }


    public User(){}

    public Set<Product> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(Set<Product> soldProducts) {
        this.soldProducts = soldProducts;
    }

    public Set<Product> getBoughtProducts() {
        return boughtProducts;
    }

    public void setBoughtProducts(Set<Product> boughtProducts) {
        this.boughtProducts = boughtProducts;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Set<User> getFriends() {
        return friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }
}
