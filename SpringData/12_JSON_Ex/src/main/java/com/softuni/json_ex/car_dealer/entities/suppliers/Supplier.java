package com.softuni.json_ex.car_dealer.entities.suppliers;

import com.softuni.json_ex.car_dealer.entities.parts.Part;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;


@Entity
@Table(name = "suppliers")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String name;

    @Column(name = "is_importer")
    private boolean isImporter;

    @OneToMany(mappedBy = "supplier",targetEntity = Part.class)
    private Set<Part> parts;

    public Supplier() {
    }

    public Supplier(String name, boolean isImporter) {
        this.name = name;
        this.isImporter = isImporter;
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

    public boolean isImporter() {
        return isImporter;
    }

    public void setImporter(boolean importer) {
        isImporter = importer;
    }

    public Set<Part> getParts() {
        return parts;
    }

    public void setParts(Set<Part> parts) {
        this.parts = parts;
    }
}
