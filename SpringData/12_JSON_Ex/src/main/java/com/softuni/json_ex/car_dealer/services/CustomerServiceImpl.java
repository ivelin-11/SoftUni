package com.softuni.json_ex.car_dealer.services;


import com.softuni.json_ex.car_dealer.entities.sales.Sale;
import com.softuni.json_ex.car_dealer.entities.cars.Car;
import com.softuni.json_ex.car_dealer.entities.customers.Customer;
import com.softuni.json_ex.car_dealer.entities.customers.CustomerInfoDTO;
import com.softuni.json_ex.car_dealer.entities.customers.CustomerSummaryDTO;
import com.softuni.json_ex.car_dealer.entities.parts.Part;
import com.softuni.json_ex.car_dealer.repositories.CustomerRepository;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper mapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
        this.mapper = new ModelMapper();
    }


    @Override
    public List<CustomerInfoDTO> getOrderedCustomers() {

        ModelMapper modelMapper = new ModelMapper();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        Converter<LocalDateTime, String> localDateTimeConverter = c -> (c.getSource().format(dateTimeFormatter));

        TypeMap<Customer, CustomerInfoDTO> propertyMapper = modelMapper.createTypeMap(Customer.class, CustomerInfoDTO.class).addMappings(
                m -> m.using(localDateTimeConverter).map(Customer::getBirthDate, CustomerInfoDTO::setBirthDate)
        );

        List<Customer> customers = this.customerRepository.findAllOrderByBirthDateAscAndIsYoungDriverDesc();
        List<CustomerInfoDTO> customerInfoDTOS = customers.stream().map(propertyMapper::map).collect(Collectors.toList());

        return customerInfoDTOS;
    }

    @Transactional
    @Override
    public List<CustomerSummaryDTO> getSalesByCustomer() {
        List<Customer> customers = this.customerRepository.getCustomersSalesCarsCount();

        List<CustomerSummaryDTO> customerSummaryDTOS = new ArrayList<>();

        customers.stream().forEach(c ->{

            List<Car> cars = c.getBoughtCars().stream().map(Sale::getCar).collect(Collectors.toList());

            BigDecimal spentMoney=BigDecimal.ZERO;

            for (Car car : cars) {
                Set<Part> parts = car.getParts();

                for (Part part : parts) {
                    spentMoney=spentMoney.add(part.getPrice());
                }
            }

            CustomerSummaryDTO customerSummaryDTO=new CustomerSummaryDTO(c.getName(),cars.size(),spentMoney);

            customerSummaryDTOS.add(customerSummaryDTO);

        });


        Collections.sort(customerSummaryDTOS,Comparator.comparing(CustomerSummaryDTO::getSpentMoney).thenComparing(CustomerSummaryDTO::getBoughtCars).reversed());

        return customerSummaryDTOS;
    }
}
