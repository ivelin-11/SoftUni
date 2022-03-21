package com.softuni.json_ex;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.softuni.json_ex.car_dealer.services.*;
import com.softuni.json_ex.productshop.entities.categories.CategoryStatsDTO;
import com.softuni.json_ex.productshop.entities.products.ProductNoBuyerDTO;
import com.softuni.json_ex.productshop.entities.users.UserWithSoldProductsDTO;
import com.softuni.json_ex.productshop.repositories.ProductRepository;
import com.softuni.json_ex.productshop.repositories.UserRepository;
import com.softuni.json_ex.productshop.services.ProductService;
import com.softuni.json_ex.productshop.services.SeedService;
import com.softuni.json_ex.productshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ConsoleRunner implements CommandLineRunner {

    //productshop
    private final SeedService seedService;
    private final ProductService productService;
    private final UserService userService;

    //carDealer
    private Seeder seeder;
    private final CarService carService;
    private final CustomerService customerService;
    private final SupplierService supplierService;
    private final SaleService saleService;

    private final Gson gson;

    @Autowired
    public ConsoleRunner(SeedService seedService, ProductService productService, UserRepository userRepository, ProductRepository productRepository, UserService userService, Seeder seeder, CarService carService, CustomerService customerService, SupplierService supplierService, SaleService saleService) {
        this.seedService = seedService;
        this.productService = productService;
        this.userService = userService;
        this.seeder = seeder;
        this.carService = carService;
        this.customerService = customerService;
        this.supplierService = supplierService;
        this.saleService = saleService;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    public void run(String... args) throws Exception {

        // CarDealerTasks
//        this.seeder.seedAll();
//        getCustomerInfo();
//        getCarsMakeToyota();
//        getLocalSuppliers();
        // getCarsAndTheirParts();
//        getTotalSalesByCustomer();
//        getSalesWithAppliedDiscounts();



        //ProductShop Tasks
//    this.seedService.seedAll();
//    getProductsPriceBetweenAndNoBuyer();
//        getUserWithSoldProductsAndBuyerNames();
//        getCategoriesStats();
//        findUsersAndSoldProducts();

    }

    private void getSalesWithAppliedDiscounts() {
        System.out.println(this.gson.toJson(this.saleService.getSalesWithAppliedDiscount()));
    }

    private void getTotalSalesByCustomer() {
        System.out.println(this.gson.toJson(this.customerService.getSalesByCustomer()));
    }

    private void getCarsAndTheirParts() {
        System.out.println(this.gson.toJson(this.carService.getCarsWithTheirParts()));
    }

    private void getLocalSuppliers() {
        System.out.println(this.gson.toJson(this.supplierService.getLocalSuppliersSoldPartsCount()));
    }

    private void getCarsMakeToyota() {
        System.out.println(this.gson.toJson(this.carService.getCarsByBrandToyota()));
    }

    private void getCustomerInfo() {
        System.out.println(this.gson.toJson(this.customerService.getOrderedCustomers()));
    }

    private void findUsersAndSoldProducts() {
        System.out.println(this.gson.toJson(this.userService.getUsersAndSoldProducts()));
    }

    private void getCategoriesStats() {
        List<CategoryStatsDTO> categoriesStatistics = this.productService.getCategoriesStatistics();
        System.out.println(this.gson.toJson(categoriesStatistics));
    }

    private void getUserWithSoldProductsAndBuyerNames() {
        List<UserWithSoldProductsDTO> usersWithSoldProducts = this.userService.getUsersWithSoldProducts();
        System.out.println(this.gson.toJson(usersWithSoldProducts));
    }

    private void getProductsPriceBetweenAndNoBuyer() {
        List<ProductNoBuyerDTO> products = this.productService.findProductsWithPriceInRangeAndNoBuyer(500, 1000);
        String s = this.gson.toJson(products);
        System.out.println(s);
    }

}
