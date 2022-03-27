package com.softuni.productshop.services;


import com.softuni.productshop.entities.products.ExportSoldProductFullInfo;
import com.softuni.productshop.entities.products.ProductCountInfoDTO;
import com.softuni.productshop.entities.products.ProductNamePriceDTO;
import com.softuni.productshop.entities.users.*;
import com.softuni.productshop.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        modelMapper = new ModelMapper();
    }


    @Override
    @Transactional
    public ExportSellersDTO getUsersWithSoldProducts() {

        List<User> users = this.userRepository.
                findAllWithSoldProducts();

        List<ExportUserWithSoldProductsDTO> dtos = users
                .stream()
                .map(this::createExportUserWithSoldCountDTO)
                .collect(Collectors.toList());

        ExportSellersDTO exportSellersDTO = new ExportSellersDTO();
        exportSellersDTO.setUsers(dtos);

        return exportSellersDTO;
    }

    @Override
    @Transactional
    public ExportUserSummary getUsersAndSoldProducts() {


        List<User> users = this.userRepository.findUsersAndSoldProducts();

        List<UserInfoDTO> userInfoDTOS = users.stream().map(u -> {

            UserInfoDTO mappedUser = this.modelMapper.map(u, UserInfoDTO.class);

            List<ProductNamePriceDTO> products = u.getSoldProducts().stream().map(p -> this.modelMapper.map(p, ProductNamePriceDTO.class))
                    .collect(Collectors.toList());

            ProductCountInfoDTO productCountInfoDTO = new ProductCountInfoDTO();
            productCountInfoDTO.setCount(u.getSoldProducts().size());
            productCountInfoDTO.setProducts(products);

            mappedUser.setProductCountInfoDTO(productCountInfoDTO);

            return mappedUser;
        }).collect(Collectors.toList());

        ExportUserSummary exportUserSummary = new ExportUserSummary();
        exportUserSummary.setCount(userInfoDTOS.size());
        exportUserSummary.setUsers(userInfoDTOS);

        return exportUserSummary;
    }

    private ExportUserWithSoldProductsDTO createExportUserWithSoldCountDTO(User u) {

        ExportUserWithSoldProductsDTO user = this.modelMapper.map(u, ExportUserWithSoldProductsDTO.class);

        List<ExportSoldProductFullInfo> products = u.getSoldProducts().stream().map(p -> this.modelMapper.map(p, ExportSoldProductFullInfo.class))
                .collect(Collectors.toList());

        user.setSoldProducts(products);

        return user;
    }
}
