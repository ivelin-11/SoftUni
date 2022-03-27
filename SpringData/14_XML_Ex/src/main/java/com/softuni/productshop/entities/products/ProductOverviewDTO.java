package com.softuni.productshop.entities.products;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
public class ProductOverviewDTO {

  @XmlAttribute
  private String name;

  @XmlAttribute
  private BigDecimal price;

  @XmlAttribute(name = "seller")
  private String sellerFullName;


  public void setName(String name) {
    this.name = name;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public void setSellerFullName(String sellerFullName) {
    this.sellerFullName = sellerFullName;
  }
}
