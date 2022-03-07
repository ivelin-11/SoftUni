package _04_HospitalDatabase.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


@Entity(name = "_04_visitations")
public class Visitation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private LocalDate date;

    @Column(columnDefinition = "TEXT")
    private String comments;

    @ManyToOne(optional = false)
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private Patient patient;


    @ManyToOne()
    @JoinColumn(name = "diagnose_id", referencedColumnName = "id")
    private Diagnose diagnose;

    @ManyToMany()
    @JoinTable( name = "_04_visitations_medicaments",
            joinColumns = @JoinColumn(name = "visitation_id", referencedColumnName = "id")   ,
            inverseJoinColumns = @JoinColumn(name = "prescribed_medicament_id", referencedColumnName = "id")
    )

    private Set<PrescribedMedicament> prescribedMedicaments;


    public void addMedicamentToVisitation(PrescribedMedicament prescribedMedicament){
        this.prescribedMedicaments.add(prescribedMedicament);
    }

    public Visitation() {
    }

    public Visitation(LocalDate date, Patient patient, Diagnose diagnose) {
        this.date = date;
        this.patient = patient;
        this.diagnose = diagnose;
        this.prescribedMedicaments=new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Patient getPatient() {
        return patient;
    }

    public Diagnose getDiagnose() {
        return diagnose;
    }

    @Override
    public String toString() {
        return "Visitation{" +
                "date=" + date +
                ", diagnose=" + diagnose +
                '}';
    }

    public Set<PrescribedMedicament> getPrescribedMedicaments() {
        return Collections.unmodifiableSet(this.prescribedMedicaments);
    }
}
