package com.softuni.productshop.entities.products;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExportProductInRangeRootDTO {

    @XmlElement(name = "product")
    private List<ProductOverviewDTO> products;


    public List<ProductOverviewDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductOverviewDTO> products) {
        this.products = products;
    }
}
