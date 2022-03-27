package com.softuni.productshop.entities.users;


import com.softuni.productshop.entities.products.ExportSoldProductFullInfo;

import javax.xml.bind.annotation.*;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)

public class ExportUserWithSoldProductsDTO {


    @XmlAttribute(name = "first-name")
    private String firstName;

    @XmlAttribute(name = "last-name")
    private String lastName;

    @XmlElementWrapper(name = "sold-products")
    @XmlElement(name = "product")
    private List<ExportSoldProductFullInfo> soldProducts;


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSoldProducts(List<ExportSoldProductFullInfo> soldProducts) {
        this.soldProducts = soldProducts;
    }
}
