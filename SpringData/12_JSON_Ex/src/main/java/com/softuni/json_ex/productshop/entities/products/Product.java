package com.softuni.json_ex.productshop.entities.products;


import com.softuni.json_ex.productshop.entities.categories.Category;
import com.softuni.json_ex.productshop.entities.users.User;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(min = 3)
    private String name;

    @NotNull
    private BigDecimal price;

    @ManyToOne()
    @JoinColumn(name ="buyer_id",referencedColumnName = "id")
    private User buyer;

    @ManyToOne()
    @JoinColumn(name ="seller_id",referencedColumnName = "id")
    private User seller;


    @ManyToMany
    private Set<Category> categories;

    public Product(String name, BigDecimal price) {
        this.categories=new HashSet<>();
        this.name = name;
        this.price = price;
    }

    public Product(){}

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
