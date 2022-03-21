package com.softuni.json_ex.car_dealer.services;


import com.google.gson.*;
import com.softuni.json_ex.car_dealer.entities.sales.Sale;
import com.softuni.json_ex.car_dealer.entities.cars.Car;
import com.softuni.json_ex.car_dealer.entities.cars.CarImportDTO;
import com.softuni.json_ex.car_dealer.entities.customers.Customer;
import com.softuni.json_ex.car_dealer.entities.customers.CustomerImportDTO;
import com.softuni.json_ex.car_dealer.entities.parts.Part;
import com.softuni.json_ex.car_dealer.entities.parts.PartImportDTO;
import com.softuni.json_ex.car_dealer.entities.suppliers.Supplier;
import com.softuni.json_ex.car_dealer.entities.suppliers.SupplierImportDTO;
import com.softuni.json_ex.car_dealer.repositories.*;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class SeederImpl implements Seeder {

    private static final String separator = File.separator;

    private static final String SUPPLIER_JSON_PATH =
            "src" + separator + "main" + separator + "resources" + separator + "jsons" + separator +
                    "suppliers.json";

    private static final String PART_JSON_PATH =
            "src" + separator + "main" + separator + "resources" + separator + "jsons" + separator +
                    "parts.json";

    private static final String CAR_JSON_PATH =
            "src" + separator + "main" + separator + "resources" + separator + "jsons" + separator +
                    "cars.json";

    private static final String CUSTOMER_JSON_PATH =
            "src" + separator + "main" + separator + "resources" + separator + "jsons" + separator +
                    "customers.json";


    private final SupplierRepository supplierRepository;
    private final PartRepository partRepository;
    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;
    private final SaleRepository saleRepository;
    private final Gson gson;
    private ModelMapper modelMapper;

    @Autowired
    public SeederImpl(SupplierRepository supplierRepository, PartRepository partRepository, CarRepository carRepository, CustomerRepository customerRepository, SaleRepository saleRepository) {
        this.supplierRepository = supplierRepository;
        this.partRepository = partRepository;
        this.carRepository = carRepository;
        this.customerRepository = customerRepository;
        this.saleRepository = saleRepository;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.modelMapper = new ModelMapper();
    }


    @Override
    public void seedSuppliers() throws FileNotFoundException {

        FileReader fileReader = new FileReader(SUPPLIER_JSON_PATH);

        SupplierImportDTO[] supplierImportDTOS = this.gson.fromJson(fileReader, SupplierImportDTO[].class);

        List<Supplier> suppliers = Arrays.stream(supplierImportDTOS).map(s -> this.modelMapper.map(s, Supplier.class)).collect(Collectors.toList());

        this.supplierRepository.saveAll(suppliers);
    }

    @Override
    public void seedParts() throws FileNotFoundException {

        FileReader fileReader = new FileReader(PART_JSON_PATH);

        PartImportDTO[] partImportDTOS = this.gson.fromJson(fileReader, PartImportDTO[].class);

        List<Part> parts = Arrays.stream(partImportDTOS).map(p -> this.modelMapper.map(p, Part.class)).collect(Collectors.toList());

        parts.forEach(p -> {

            long randomId = ThreadLocalRandom.current().nextLong(1, this.supplierRepository.count() + 1);

            Optional<Supplier> randomSupplier = this.supplierRepository.findById(randomId);

            p.setSupplier(randomSupplier.get());
        });

        this.partRepository.saveAll(parts);
    }

    @Override
    public void seedCars() throws FileNotFoundException {
        FileReader fileReader = new FileReader(CAR_JSON_PATH);

        //read from json to list
        Type carImportDTOType = new TypeToken<ArrayList<CarImportDTO>>() {
        }.getType();
        List<CarImportDTO> carImportDTOList = this.gson.fromJson(fileReader, carImportDTOType);

        List<Car> cars = carImportDTOList.stream().map(c -> this.modelMapper.map(c, Car.class)).collect(Collectors.toList());

        cars.stream().forEach(c -> {

            int partsNumber = new Random().nextInt(5) + 1;


            Set<Part> parts = new HashSet<>();
            int i = 0;
            while (parts.size() < 3 || i < partsNumber) {

                long randomId = ThreadLocalRandom.current().nextLong(1, this.partRepository.count() + 1);

                Optional<Part> byId = this.partRepository.findById(randomId);

                parts.add(byId.get());
                i++;
            }

            c.setParts(parts);
        });


        this.carRepository.saveAll(cars);
    }

    @Override
    public void seedCustomers() throws FileNotFoundException {
        FileReader fileReader = new FileReader(CUSTOMER_JSON_PATH);

        //read from json to list
        Type customerImportDTOType = new TypeToken<ArrayList<CustomerImportDTO>>() {
        }.getType();
        List<CustomerImportDTO> customerImportDTOS = this.gson.fromJson(fileReader, customerImportDTOType);


        ModelMapper mapper = new ModelMapper();

//DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX"); for miliseconds
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        Converter<String, LocalDateTime> localDateTimeConverter = c -> LocalDateTime.parse(c.getSource(), dateTimeFormatter);

        TypeMap<CustomerImportDTO, Customer> propertyMapper = mapper.createTypeMap(CustomerImportDTO.class, Customer.class).addMappings(
                m -> m.using(localDateTimeConverter).map(CustomerImportDTO::getBirthDate, Customer::setBirthDate)
        );

        List<Customer> customers = customerImportDTOS.stream().map(propertyMapper::map).collect(Collectors.toList());

        this.customerRepository.saveAll(customers);
    }

    @Override
    public void seedSales() {

        int orders = 100;

        List<Integer> discounts = List.of(0, 5, 10, 15, 20, 30, 40, 50);
        List<Sale> sales = new ArrayList<>();

        List<Long> generatesCarsIDS = new ArrayList<>();

        IntStream.rangeClosed(1, orders).forEach(i -> {

            long carID = ThreadLocalRandom.current().nextLong(1, this.carRepository.count() + 1);


            //sale - car is one to one so we mustn't have repeated ids
            while (generatesCarsIDS.contains(carID)) {
                carID = ThreadLocalRandom.current().nextLong(1, this.carRepository.count() + 1);
            }
            generatesCarsIDS.add(carID);
            Optional<Car> car = this.carRepository.findById(carID);

            long customerID = ThreadLocalRandom.current().nextLong(1, this.customerRepository.count() + 1);
            Optional<Customer> customer = this.customerRepository.findById(customerID);

            int discount = new Random().nextInt(discounts.size());

            Sale sale = new Sale();
            sale.setDiscount(discounts.get(discount));
            sale.setCar(car.get());
            sale.setCustomer(customer.get());

            sales.add(sale);
        });
        this.saleRepository.saveAll(sales);
    }
}
