package softuni.exam.service.impl;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ApartmentImportRootDTO;
import softuni.exam.models.dto.OfferImportDTO;
import softuni.exam.models.dto.OfferImportRootDTO;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.ApartmentType;
import softuni.exam.models.entity.Offer;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.OfferService;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class OfferServiceImpl implements OfferService {

    Path path = Path.of("src", "main", "resources", "files", "xml", "offers.xml");

    private final AgentRepository agentRepository;
    private final ApartmentRepository apartmentRepository;
    private final OfferRepository offerRepository;
    private final Unmarshaller unmarshaller;
    private final ModelMapper modelMapper;
    private final Validator valdator;

    @Autowired
    public OfferServiceImpl(AgentRepository agentRepository, ApartmentRepository apartmentRepository, OfferRepository offerRepository) throws JAXBException {
        this.agentRepository = agentRepository;
        this.apartmentRepository = apartmentRepository;
        this.offerRepository = offerRepository;
        JAXBContext context = JAXBContext.newInstance(OfferImportRootDTO.class);
        this.unmarshaller = context.createUnmarshaller();
        this.modelMapper = new ModelMapper();
        this.modelMapper.addConverter(new Converter<String, LocalDate>() {
            @Override
            public LocalDate convert(MappingContext<String, LocalDate> mappingContext) {
                return LocalDate.parse(mappingContext.getSource(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            }
        });
        this.valdator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Override
    public boolean areImported() {
        return this.offerRepository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return Files.readString(path);
    }

    @Override
    public String importOffers() throws IOException, JAXBException {

        OfferImportRootDTO offerImportRootDTO = (OfferImportRootDTO) this.unmarshaller.unmarshal(path.toFile());

        return offerImportRootDTO.getOffers().stream().map(this::importOffer).collect(Collectors.joining("\n"));

    }

    private String importOffer(OfferImportDTO offerImportDTO) {

        Set<ConstraintViolation<OfferImportDTO>> errors = this.valdator.validate(offerImportDTO);

        if (errors.size() > 0) {
            return "Invalid offer";
        }


//        • If agent with the given name doesn’t already exist in the DB return "Invalid offer".
        Optional<Agent> optionalAgent = this.agentRepository.findByFirstName(offerImportDTO.getAgentNameDTO().getName());
        if (optionalAgent.isEmpty()) {
            return "Invalid offer";
        }

//    • The provided apartment ids will always be valid.
        Optional<Apartment> optionalApartment = this.apartmentRepository.findById(offerImportDTO.getApartmentIdDTO().getId());

        Offer offer = this.modelMapper.map(offerImportDTO, Offer.class);

        offer.setAgent(optionalAgent.get());
        offer.setApartment(optionalApartment.get());

        this.offerRepository.save(offer);

//    • Format the price to the second digit after the decimal point.
        return String.format("Successfully imported offer %s",
                new DecimalFormat("##############.00").format(offer.getPrice()));
    }

    @Override
    public String exportOffers() {
        List<Offer> offers = this.offerRepository.findByApartmentTypeOrderByAreaDescPriceAsc(ApartmentType.three_rooms);

        return offers.stream().map(String::valueOf).collect(Collectors.joining("\n"));
    }
}
