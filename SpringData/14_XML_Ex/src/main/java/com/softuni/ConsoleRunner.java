package com.softuni;


import com.softuni.productshop.entities.categories.ExportCategoryInfo;
import com.softuni.productshop.entities.products.ExportProductInRangeRootDTO;
import com.softuni.productshop.entities.users.ExportSellersDTO;
import com.softuni.productshop.entities.users.ExportUserSummary;
import com.softuni.productshop.services.ProductService;
import com.softuni.productshop.services.SeedService;
import com.softuni.productshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


@Component
public class ConsoleRunner implements CommandLineRunner {

    private final SeedService seedService;
    private final ProductService productService;
    private final UserService userService;


    @Autowired
    public ConsoleRunner(SeedService seedService, ProductService productService, UserService userService) {
        this.seedService = seedService;
        this.productService = productService;
        this.userService = userService;
    }


    @Override
    public void run(String... args) throws Exception {



        ExportUserSummary exportUserSummary= this.userService.getUsersAndSoldProducts();
        JAXBContext context = JAXBContext.newInstance(ExportUserSummary.class);

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);

        marshaller.marshal(exportUserSummary,System.out);
//        cateoriesByProductsCount();
//        successfullySoldProducts();
//        productsInRange();
    }

    private void cateoriesByProductsCount() throws JAXBException {
        ExportCategoryInfo categoryInfo = this.productService.getProductsStatsByCategories();
        JAXBContext context = JAXBContext.newInstance(ExportCategoryInfo.class);

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);

        marshaller.marshal(categoryInfo,System.out);
    }

    private void successfullySoldProducts() throws JAXBException {
        ExportSellersDTO usersWithSoldProducts = this.userService.getUsersWithSoldProducts();

        JAXBContext context = JAXBContext.newInstance(ExportSellersDTO.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(usersWithSoldProducts, System.out);
    }

    private void productsInRange() throws JAXBException {
        ExportProductInRangeRootDTO inPriceRange = this.productService.getProductsInPriceRange(500, 1000);

        JAXBContext context = JAXBContext.newInstance(ExportProductInRangeRootDTO.class);

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(inPriceRange, System.out);
    }
}
