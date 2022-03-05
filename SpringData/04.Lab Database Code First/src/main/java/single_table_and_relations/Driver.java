package single_table_and_relations;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "drivers")
public class Driver {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "full_name")
    private String fullName;


    @ManyToMany()
    @JoinTable(name = "drivers_trucks",
            joinColumns = @JoinColumn(name = "driver_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "truck_id", referencedColumnName = "id")
    )
    private Set<Truck> trucks;

    public Driver() {
    }

    public void addTruck(Truck truck) {
        this.trucks.add(truck);
    }

    public Driver(String fullName) {
        this.fullName = fullName;
        this.trucks = new HashSet<>();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    public Set<Truck> getTrucks() {
        return trucks;
    }
}
