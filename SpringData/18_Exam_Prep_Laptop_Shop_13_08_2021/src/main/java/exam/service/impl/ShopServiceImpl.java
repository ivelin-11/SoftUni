package exam.service.impl;

import exam.model.dtos.ShopImportDTO;
import exam.model.dtos.ShopImportRootDTO;
import exam.model.entities.Shop;
import exam.model.entities.Town;
import exam.repository.ShopRepository;
import exam.repository.TownRepository;
import exam.service.ShopService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class ShopServiceImpl implements ShopService {

    Path path = Path.of("src", "main", "resources", "files", "xml", "shops.xml");

    private final ShopRepository shopRepository;
    private final TownRepository townRepository;
    private final Validator validator;
    private final Unmarshaller unmarshaller;
    private ModelMapper modelMapper;

    @Autowired
    public ShopServiceImpl(ShopRepository shopRepository, TownRepository townRepository) throws JAXBException {
        this.shopRepository = shopRepository;
        this.townRepository = townRepository;
        JAXBContext context = JAXBContext.newInstance(ShopImportRootDTO.class);
        this.unmarshaller = context.createUnmarshaller();
        this.modelMapper = new ModelMapper();
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();

    }

    @Override
    public boolean areImported() {
        return this.shopRepository.count() > 0;
    }

    @Override
    public String readShopsFileContent() throws IOException {
        return Files.readString(path);
    }

    @Override
    public String importShops() throws JAXBException, FileNotFoundException {

        ShopImportRootDTO shopImportRootDTO = (ShopImportRootDTO) this.unmarshaller.unmarshal(new FileReader(path.toAbsolutePath().toString()));

        return shopImportRootDTO.getShops().stream().map(this::importShop).collect(Collectors.joining("\n"));

    }

    private String importShop(ShopImportDTO shopImportDTO) {

        Set<ConstraintViolation<ShopImportDTO>> errors = this.validator.validate(shopImportDTO);

        if (errors.size() > 0) {
            return "Invalid shop";
        }

        Optional<Shop> optionalShop = this.shopRepository.findByName(shopImportDTO.getName());

        if (optionalShop.isPresent()) {
            return "Invalid shop";
        }

        Shop shop = this.modelMapper.map(shopImportDTO, Shop.class);

        Optional<Town> optionalTown = this.townRepository.findByName(shopImportDTO.getTown().getName());
        shop.setTown(optionalTown.get());

        this.shopRepository.save(shop);

        return String.format("Successfully imported Shop %s - %s", shop.getName(), shop.getIncome().toString());
    }
}
