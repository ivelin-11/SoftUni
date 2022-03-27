package com.softuni.productshop.services;


import com.softuni.productshop.entities.categories.CategoryStatsDTO;
import com.softuni.productshop.entities.categories.ExportCategoryInfo;
import com.softuni.productshop.entities.products.ExportProductInRangeRootDTO;
import com.softuni.productshop.entities.products.Product;
import com.softuni.productshop.entities.products.ProductOverviewDTO;
import com.softuni.productshop.entities.users.User;
import com.softuni.productshop.repositories.ProductRepository;
import org.modelmapper.*;
import org.modelmapper.spi.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final TypeMap<Product, ProductOverviewDTO> mapperProductToDTO;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
        this.modelMapper = new ModelMapper();


        Converter<User, String> userFullNameConverter =
                context -> context.getSource() == null ? null : context.getSource().getFullName();
        this.mapperProductToDTO = this.modelMapper.createTypeMap(Product.class, ProductOverviewDTO.class);

        this.mapperProductToDTO.addMappings(map -> map.using(userFullNameConverter).map(Product::getSeller, ProductOverviewDTO::setSellerFullName));
    }


    @Override
    public ExportProductInRangeRootDTO getProductsInPriceRange(int lower, int higher) {

        BigDecimal lowerBound = BigDecimal.valueOf(lower);
        BigDecimal upperBound = BigDecimal.valueOf(higher);

        List<Product> products =
                this.productRepository.findAllByPriceBetweenAndBuyerIsNotNullOrderByPriceAsc(lowerBound, upperBound);

        List<ProductOverviewDTO> dtos = products.stream().map(this.mapperProductToDTO::map).collect(Collectors.toList());

        ExportProductInRangeRootDTO exportProductInRangeRootDTO = new ExportProductInRangeRootDTO();

        exportProductInRangeRootDTO.setProducts(dtos);

        return exportProductInRangeRootDTO;
    }

    @Override
    @Transactional
    public ExportCategoryInfo getProductsStatsByCategories() {

        List<CategoryStatsDTO> categoriesStats = this.productRepository.getCategoriesStats();

        ExportCategoryInfo exportCategoryInfo=new ExportCategoryInfo();

        exportCategoryInfo.setCategories(categoriesStats);

        return exportCategoryInfo;
    }
}

