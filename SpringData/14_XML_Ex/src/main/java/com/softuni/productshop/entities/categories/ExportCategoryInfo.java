package com.softuni.productshop.entities.categories;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExportCategoryInfo {


    @XmlElement(name ="category")
    private List<CategoryStatsDTO> categories;

    public void setCategories(List<CategoryStatsDTO> categories) {
        this.categories = categories;
    }
}
