package com.softuni.json_ex.car_dealer.entities.sales;


import com.softuni.json_ex.car_dealer.entities.cars.Car;
import com.softuni.json_ex.car_dealer.entities.customers.Customer;

import javax.persistence.*;


@Entity
@Table(name = "sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int discount;

    @OneToOne(optional = false)
    private Car car;

    @ManyToOne(optional = false)
    private Customer customer;

    public Sale() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
