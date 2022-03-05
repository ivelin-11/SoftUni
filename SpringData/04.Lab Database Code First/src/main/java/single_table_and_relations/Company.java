package single_table_and_relations;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToMany(mappedBy = "company",targetEntity = Plane.class)
    Set<Plane> planes;

    public Company() {
    }

    public Company(String name) {
        this.name = name;
        this.planes = new HashSet<>();
    }


    public long getId() {
        return id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Plane> getPlanes() {
        return Collections.unmodifiableSet(planes);
    }

    public void setPlanes(Set<Plane> planes) {
        this.planes = planes;
    }
}
