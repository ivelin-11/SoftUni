package _04_HospitalDatabase.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "_04_patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(nullable = false)
    private String address;


    private String email;

    @Column(name = "date_birth", nullable = false)
    private LocalDate dateBirth;

    @Lob
    @Column(name = "picture", length = 100000)
    private byte[] picture;

    @Column(name = "medical_insurance", nullable = false)
    private boolean medicalInsurance;


    @OneToMany(mappedBy = "patient")
    Set<Visitation> visitations;

    public Patient() {
    }

    public Patient(String firstName, String lastName, String address, LocalDate dateBirth, boolean medicalInsurance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.dateBirth = dateBirth;
        this.medicalInsurance = medicalInsurance;
        this.visitations = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public boolean isMedicalInsurance() {
        return medicalInsurance;
    }

    public void setMedicalInsurance(boolean medicalInsurance) {
        this.medicalInsurance = medicalInsurance;
    }

    public Set<Visitation> getVisitations() {
        return Collections.unmodifiableSet(this.visitations);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", dateBirth=" + dateBirth +
                ", medicalInsurance=" + medicalInsurance +
                ", visitations=" + visitations +
                '}';
    }
}
