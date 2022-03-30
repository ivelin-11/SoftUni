package softuni.exam.service.impl;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.TicketImportDTO;
import softuni.exam.models.dto.TicketImportRootDTO;
import softuni.exam.models.entities.Passenger;
import softuni.exam.models.entities.Plane;
import softuni.exam.models.entities.Ticket;
import softuni.exam.models.entities.Town;
import softuni.exam.repository.PassengerRepository;
import softuni.exam.repository.PlaneRepository;
import softuni.exam.repository.TicketRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TicketService;

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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {

    Path path = Path.of("src", "main", "resources", "files", "xml", "tickets.xml");

    private final TicketRepository ticketRepository;
    private final TownRepository townRepository;
    private final PassengerRepository passengerRepository;
    private final PlaneRepository planeRepository;
    private final Unmarshaller unmarshaller;
    private final ModelMapper mapper;
    private final Validator validator;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository, TownRepository townRepository, PassengerRepository passengerRepository, PlaneRepository planeRepository) throws JAXBException {
        this.ticketRepository = ticketRepository;
        this.townRepository = townRepository;
        this.passengerRepository = passengerRepository;
        this.planeRepository = planeRepository;
        this.mapper = new ModelMapper();
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();

        this.mapper.addConverter(new Converter<String, LocalDateTime>() {
            @Override
            public LocalDateTime convert(MappingContext<String, LocalDateTime> mappingContext) {
                return LocalDateTime.parse(mappingContext.getSource(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            }
        });
        JAXBContext context = JAXBContext.newInstance(TicketImportRootDTO.class);
        this.unmarshaller = context.createUnmarshaller();
    }

    @Override
    public boolean areImported() {
        return this.ticketRepository.count() > 0;
    }

    @Override
    public String readTicketsFileContent() throws IOException {
        return
                Files.readString(path);
    }

    @Override
    public String importTickets() throws FileNotFoundException, JAXBException {

        TicketImportRootDTO tickets = (TicketImportRootDTO) this.unmarshaller.unmarshal(new FileReader(path.toAbsolutePath().toString()));

return  tickets.getTickets().stream().map(this::importTicket).collect(Collectors.joining("\n"));
    }

    private String importTicket(TicketImportDTO ticketImportDTO) {

        Set<ConstraintViolation<TicketImportDTO>> errors = this.validator.validate(ticketImportDTO);

        if(errors.size()>0){
            return  "Invalid Ticket";
        }

        if( this.ticketRepository.findBySerialNumber(ticketImportDTO.getSerialNumber()).isPresent()){
            return  "Invalid Ticket";
        }

        Ticket ticket = this.mapper.map(ticketImportDTO, Ticket.class);

        Optional<Town> optFromTown = this.townRepository.findByName(ticketImportDTO.getFromTown().getName());
        Optional<Town> optToTown = this.townRepository.findByName(ticketImportDTO.getToTown().getName());

        ticket.setFromTown(optFromTown.get());
        ticket.setToTown(optToTown.get());

        Optional<Passenger> optionalPassenger = this.passengerRepository.findByEmail(ticketImportDTO.getEmail().getEmail());
        ticket.setPassenger(optionalPassenger.get());

        Optional<Plane> optionalPlane = this.planeRepository.findByRegisterNumber(ticketImportDTO.getPlane().getRegisterNumber());

        ticket.setPlane(optionalPlane.get());

        this.ticketRepository.save(ticket);

        return String.format("Successfully imported Ticket %s - %s", ticket.getFromTown().getName(),ticket.getToTown().getName());
    }
}
