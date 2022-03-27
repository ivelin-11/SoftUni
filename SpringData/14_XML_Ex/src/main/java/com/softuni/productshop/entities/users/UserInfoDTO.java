package com.softuni.productshop.entities.users;


import com.softuni.productshop.entities.products.ProductCountInfoDTO;
import com.softuni.productshop.entities.products.ProductNamePriceDTO;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class UserInfoDTO {

    @XmlAttribute(name = "first-name")
    private String firstName;

    @XmlAttribute(name = "last-name")
    private String lastName;

    @XmlAttribute
    private int age;

    @XmlElement(name = "sold-products")
   private ProductCountInfoDTO productCountInfoDTO;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setProductCountInfoDTO(ProductCountInfoDTO productCountInfoDTO) {
        this.productCountInfoDTO = productCountInfoDTO;
    }
}
