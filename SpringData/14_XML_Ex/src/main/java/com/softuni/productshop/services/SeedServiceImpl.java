package com.softuni.productshop.services;


import com.softuni.productshop.entities.categories.Category;
import com.softuni.productshop.entities.categories.CategoryImportRootDTO;
import com.softuni.productshop.entities.products.ProductImportRootDTO;
import com.softuni.productshop.entities.products.Product;
import com.softuni.productshop.entities.users.User;
import com.softuni.productshop.entities.users.UsersImportRootDTO;
import com.softuni.productshop.repositories.CategoryRepository;
import com.softuni.productshop.repositories.ProductRepository;
import com.softuni.productshop.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;

import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Component
public class SeedServiceImpl implements SeedService {

    private static final Path USERS_XML_PATH =
            Path.of("src", "main", "resources", "xmls", "users.xml");

    private static final String CATEGORIES_XML_PATH =
            "src" + File.separator + "main" + File.separator +
                    File.separator + "resources" + File.separator + "xmls" +
                    File.separator + "categories.xml";

    private static final String PRODUCTS_XML_PATH =
            "src" + File.separator + "main" + File.separator +
                    File.separator + "resources" + File.separator + "xmls" +
                    File.separator + "products.xml";

    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;


    @Autowired
    public SeedServiceImpl(UserRepository userRepository, CategoryRepository categoryRepository, ProductRepository productRepository) {

        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.modelMapper = new ModelMapper();

    }

    @Override
    public void seedUsers() throws IOException, JAXBException {


        JAXBContext context = JAXBContext.newInstance(UsersImportRootDTO.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        BufferedReader xmlReader = Files.newBufferedReader(USERS_XML_PATH);
        UsersImportRootDTO usersDTOs = (UsersImportRootDTO) unmarshaller.unmarshal(xmlReader);

        List<User> users = usersDTOs.getUsers().stream().map(importDTO ->
                this.modelMapper.map(importDTO, User.class)).collect(Collectors.toList());
        this.userRepository.saveAll(users);
    }

    @Override
    public void seedCategories() throws IOException, JAXBException {

        JAXBContext context = JAXBContext.newInstance(CategoryImportRootDTO.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        BufferedReader xmlReader = Files.newBufferedReader(Path.of(CATEGORIES_XML_PATH));

        CategoryImportRootDTO categoriesDTOs = (CategoryImportRootDTO) unmarshaller.unmarshal(xmlReader);

        List<Category> categories = categoriesDTOs.getCategories().stream().map(importDTO -> this.modelMapper.map(importDTO, Category.class))
                .collect(Collectors.toList());

        this.categoryRepository.saveAll(categories);

    }

    @Override
    public void seedProducts() throws IOException, JAXBException {


        JAXBContext context = JAXBContext.newInstance(ProductImportRootDTO.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        ProductImportRootDTO productDtos = (ProductImportRootDTO) unmarshaller.unmarshal(Files.newBufferedReader(Path.of(PRODUCTS_XML_PATH)));

        List<Product> products = productDtos.getProducts().stream().map(importDTO ->
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

        for (int i = 0; i < productCategoriesCount; i++) {
            long randomId = ThreadLocalRandom.current().nextLong(1L, countCategoriesDB + 1);

            Optional<Category> byId = this.categoryRepository.findById(randomId);

            categories.add(byId.get());

        }

        product.setCategories(categories);

        return product;
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
