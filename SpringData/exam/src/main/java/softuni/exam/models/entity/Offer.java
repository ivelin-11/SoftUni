package softuni.exam.models.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;

@Entity
@Table(name = "offers")
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(nullable = false)
    private BigDecimal price;

    @Column(name = "published_on",nullable = false)
    private LocalDate publishedOn;


    @ManyToOne(optional = false)
    private Apartment apartment;

    @ManyToOne(optional = false)
    private  Agent agent;

    public  Offer(){
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(LocalDate publishedOn) {
        this.publishedOn = publishedOn;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    @Override
    public String toString() {
       StringBuilder output = new StringBuilder();

        DecimalFormat df = new DecimalFormat("##############.00");
        output.append(String.format("Agent %s %s with offer №%d:%n",agent.getFirstName(),agent.getLastName(),id));
        output.append(String.format("\t-Apartment area: %s%n",df.format(apartment.getArea())));
        output.append(String.format("\t--Town: %s%n", apartment.getTown().getTownName()));
        output.append(String.format("\t---Price: %s$",df.format(price)));

        return output.toString();
    }
}
