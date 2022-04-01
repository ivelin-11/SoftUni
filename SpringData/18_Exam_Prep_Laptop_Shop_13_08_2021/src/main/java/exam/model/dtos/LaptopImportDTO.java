package exam.model.dtos;

import exam.model.entities.WarrantyType;

import javax.validation.constraints.*;
import java.math.BigDecimal;


public class LaptopImportDTO {

    @NotNull
    @Size(min = 9)
   private String macAddress;

    @NotNull
    @Positive
    private double cpuSpeed;

    @NotNull
    @Min(8)
    @Max(128)
    private int ram;

    @NotNull
    @Min(128)
    @Max(1024)
    private int storage;

    @NotNull
    @Size(min = 10)
    private String description;

    @NotNull
    @Positive
    private BigDecimal price;

    @NotNull
    private WarrantyType warrantyType;

    @NotNull
    private ShopNameDTO shop;

    public String getMacAddress() {
        return macAddress;
    }

    public double getCpuSpeed() {
        return cpuSpeed;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public WarrantyType getWarrantyType() {
        return warrantyType;
    }

    public ShopNameDTO getShop() {
        return shop;
    }
}
