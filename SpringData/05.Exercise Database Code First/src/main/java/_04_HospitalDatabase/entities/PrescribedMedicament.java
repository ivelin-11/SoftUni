package _04_HospitalDatabase.entities;

import javax.persistence.*;

@Entity
@Table(name = "_04_prescribed_medicaments")
public class PrescribedMedicament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 50)
    private String name;

    public PrescribedMedicament() {
    }

    public PrescribedMedicament(String name) {
        this.name = name;
    }

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

    @Override
    public String toString() {
        return "PrescribedMedicament{" +
                "name='" + name + '\'' +
                '}';
    }
}
