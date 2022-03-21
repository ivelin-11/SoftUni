package com.softuni.json_ex.car_dealer.services;


import com.softuni.json_ex.car_dealer.entities.cars.CarBasicInfoDTO;
import com.softuni.json_ex.car_dealer.entities.parts.Part;
import com.softuni.json_ex.car_dealer.entities.sales.Sale;
import com.softuni.json_ex.car_dealer.entities.sales.SaleDiscountDTO;
import com.softuni.json_ex.car_dealer.repositories.SaleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public SaleServiceImpl(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
        modelMapper = new ModelMapper();
    }

    @Override
    @Transactional
    public List<SaleDiscountDTO> getSalesWithAppliedDiscount() {

        List<Sale> sales = this.saleRepository.findSalesWithAppliedDisount();

        List<SaleDiscountDTO> saleDiscountDTOS = new ArrayList<>();

        sales.stream().forEach(s -> {

            SaleDiscountDTO saleDiscountDTO = new SaleDiscountDTO();

            CarBasicInfoDTO car = this.modelMapper.map(s.getCar(), CarBasicInfoDTO.class);

            saleDiscountDTO.setCar(car);

            saleDiscountDTO.setCustomerName(s.getCustomer().getName());
            saleDiscountDTO.setDiscount(s.getDiscount()/100.0);


            BigDecimal price=BigDecimal.ZERO;
            Set<Sale> sellings = s.getCustomer().getBoughtCars();


            for (Sale selling : sellings) {
                Set<Part> parts = selling.getCar().getParts();
                for (Part part : parts) {
                price = price.add(part.getPrice());
            }
            };


            saleDiscountDTO.setPrice(price);

            BigDecimal discounter = saleDiscountDTO.getPrice().
                    multiply(BigDecimal.valueOf(saleDiscountDTO.getDiscount()));


            BigDecimal priceWithDiscount = saleDiscountDTO.getPrice().subtract(discounter);

            saleDiscountDTO.setPriceWithDiscount(priceWithDiscount);

            saleDiscountDTOS.add(saleDiscountDTO);
        });
        return saleDiscountDTOS;
    }

}
