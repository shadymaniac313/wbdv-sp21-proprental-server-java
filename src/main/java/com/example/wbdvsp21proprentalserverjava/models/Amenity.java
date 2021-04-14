package com.example.wbdvsp21proprentalserverjava.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "amenities")
public class Amenity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;
    @Column(name = "AMENITY_DESCRIPTION")
    private String description;
    @ManyToMany(mappedBy = "amenities")
    @JsonBackReference
    private Set<Property> owningProperties;

    public Amenity() {}

    public Amenity(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Amenity{" +
          "id=" + id +
          ", description='" + description + '\'' +
          '}';
    }
}
