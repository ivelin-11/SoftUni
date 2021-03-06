package softuni.exam.models.entities;




import javax.persistence.*;

@Entity
@Table(name = "towns")
public class Town {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true,nullable = false)
    private String name;

    private int population;

    @Column(columnDefinition = "TEXT")
    private String guide;

    public Town(String name, int population, String guide) {
        this.name = name;
        this.population = population;
        this.guide = guide;
    }

    public Town(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }
}
