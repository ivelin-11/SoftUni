package com.softuni.productshop.entities.products;

import com.softuni.productshop.entities.products.ProductImportDTO;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductImportRootDTO {

    @XmlElement(name = "product")
    private List<ProductImportDTO> products;

    public List<ProductImportDTO> getProducts() {
        return products;
    }
}
