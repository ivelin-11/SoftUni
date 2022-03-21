package com.softuni.json_ex.productshop.services;

import com.softuni.json_ex.productshop.entities.products.ProductCoutInfoDTO;
import com.softuni.json_ex.productshop.entities.products.ProductInfoDTO;
import com.softuni.json_ex.productshop.entities.users.User;
import com.softuni.json_ex.productshop.entities.users.UserInfoDTO;
import com.softuni.json_ex.productshop.entities.users.UserWithSoldProductsDTO;
import com.softuni.json_ex.productshop.entities.users.UsersAndSoldProductsDTO;
import com.softuni.json_ex.productshop.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
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
    public List<UserWithSoldProductsDTO> getUsersWithSoldProducts() {
        List<User> usersWithSoldProductsAndBuyers = this.userRepository.findUsersWithSoldProductsAndBuyers();

        return usersWithSoldProductsAndBuyers.stream().map(user -> this.modelMapper.map(user, UserWithSoldProductsDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UsersAndSoldProductsDTO getUsersAndSoldProducts() {

        List<User> allUsers = this.userRepository.findUsersAndSoldProducts();
//
        int totalUsers = allUsers.size();


        UsersAndSoldProductsDTO dto = new UsersAndSoldProductsDTO(totalUsers);

        List<UserInfoDTO> collect1 = allUsers.stream().map(user -> {

            int count = user.getSoldProducts().size();
            ModelMapper mapper = new ModelMapper();
            TypeMap<User, UserInfoDTO> typeMap =
                    mapper.createTypeMap(User.class, UserInfoDTO.class);

            typeMap.addMappings(m -> m.skip(UserInfoDTO::setSoldProducts));

            UserInfoDTO userInfoDTO = typeMap.map(user);

//    List<ProductInfoDTO> collect = user.getSoldProducts().stream().map(p -> this.modelMapper.map(p, ProductInfoDTO.class)).collect(Collectors.toList());
            ProductCoutInfoDTO productCoutInfoDTO = new ProductCoutInfoDTO();
            productCoutInfoDTO.setCount(user.getSoldProducts().size());

            List<ProductInfoDTO> collect = user.getSoldProducts().stream().map(p -> this.modelMapper.map(p, ProductInfoDTO.class)).collect(Collectors.toList());
            productCoutInfoDTO.setProducts(collect);
            userInfoDTO.setSoldProducts(productCoutInfoDTO);


            return userInfoDTO;
        }).collect(Collectors.toList());

        dto.setUsers(collect1);
        return  dto;
    }
}
