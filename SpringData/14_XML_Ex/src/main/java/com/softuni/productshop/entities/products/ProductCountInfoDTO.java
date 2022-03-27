package com.softuni.productshop.entities.products;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class ProductCountInfoDTO {


    @XmlAttribute
    private int count;

    @XmlElement(name = "product")
    private List<ProductNamePriceDTO> products;


    public void setCount(int count) {
        this.count = count;
    }

    public void setProducts(List<ProductNamePriceDTO> products) {
        this.products = products;
    }

}
