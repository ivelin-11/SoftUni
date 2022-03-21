package com.softuni.json_ex.productshop.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.softuni.json_ex.productshop.entities.categories.Category;
import com.softuni.json_ex.productshop.entities.categories.CategoryImportDTO;
import com.softuni.json_ex.productshop.entities.products.Product;
import com.softuni.json_ex.productshop.entities.products.ProductImportDTO;
import com.softuni.json_ex.productshop.entities.users.User;
import com.softuni.json_ex.productshop.entities.users.UserImportDTO;
import com.softuni.json_ex.productshop.repositories.CategoryRepository;
import com.softuni.json_ex.productshop.repositories.ProductRepository;
import com.softuni.json_ex.productshop.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.io.*;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Component
public class SeedServiceImpl implements SeedService {

    private static final Path USERS_JSON_PATH =
            Path.of("src", "main", "resources", "jsons", "users.json");

    private static final String CATEGORIES_JSON_PATH =
            "src" + File.separator + "main" + File.separator +
                    File.separator + "resources" + File.separator + "jsons" +
                    File.separator + "categories.json";

    private static final String PRODUCTS_JSON_PATH =
            "src" + File.separator + "main" + File.separator +
                    File.separator + "resources" + File.separator + "jsons" +
                    File.separator + "products.json";

    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;

    @Autowired
    public SeedServiceImpl(UserRepository userRepository, CategoryRepository categoryRepository, ProductRepository productRepository) {

        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.modelMapper = new ModelMapper();
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    public void seedUsers() throws FileNotFoundException {
        FileReader reader = new FileReader(USERS_JSON_PATH.toAbsolutePath().toString());


        UserImportDTO[] userImportDTOS =
                gson.fromJson(reader, UserImportDTO[].class);

        List<User> users = Arrays.stream(userImportDTOS).map(importDTO ->
                this.modelMapper.map(importDTO, User.class)).collect(Collectors.toList());
        this.userRepository.saveAll(users);
    }

    @Override
    public void seedCategories() throws IOException {

        FileReader fileReader = new FileReader(CATEGORIES_JSON_PATH);

        CategoryImportDTO[] categoryImportDTOS = gson.fromJson(fileReader, CategoryImportDTO[].class);

        List<Category> categories = Arrays.stream(categoryImportDTOS).map(importDTO -> this.modelMapper.map(importDTO, Category.class))
                .collect(Collectors.toList());

        this.categoryRepository.saveAll(categories);
    }

    @Override
    public void seedProducts() throws FileNotFoundException {
        FileReader fileReader = new FileReader(PRODUCTS_JSON_PATH);

        ProductImportDTO[] productImportDTOS = gson.fromJson(fileReader, ProductImportDTO[].class);

        List<Product> products = Arrays.stream(productImportDTOS).map(importDTO ->
                        this.modelMapper.map(importDTO, Product.class))
                .map(this::setRandomSeller)
                .map(this::setRandomBuyer)
                .map(this::setRandomCategories).
                collect(Collectors.toList());

        this.productRepository.saveAll(products);

    }


    private Product setRandomCategories(Product product) {

        long countCategoriesDB = this.categoryRepository.count();

        long productCategoriesCount = ThreadLocalRandom.current().nextLong(1L, countCategoriesDB + 1);

        Set<Category> categories = new HashSet<>();

        for(int i=0;i<productCategoriesCount;i++){
           long randomId=ThreadLocalRandom.current().nextLong(1L, countCategoriesDB + 1);

            Optional<Category> byId = this.categoryRepository.findById(randomId);

            categories.add(byId.get());

        }

        product.setCategories(categories);

        return  product;
    }


    private Product setRandomBuyer(Product product) {

        if (product.getPrice().compareTo(BigDecimal.valueOf(944)) > 0) {
            return product;
        }
        Optional<User> buyer = getRandomUser();

        product.setBuyer(buyer.get());

        return product;
    }


    private Product setRandomSeller(Product product) {
        Optional<User> seller = getRandomUser();

        product.setSeller(seller.get());

        return product;
    }

    private Optional<User> getRandomUser() {
        long count = this.userRepository.count();

        long randomId = ThreadLocalRandom.current().nextLong(1L, count + 1);

        Optional<User> user = this.userRepository.findById(randomId);
        return user;
    }
}
