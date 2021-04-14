package com.example.wbdvsp21proprentalserverjava.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "properties")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;
    private String propertySource;
    @OneToOne(mappedBy = "property", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    @JsonManagedReference
    private PropertyDetails propertyDetails;
    @ManyToMany
    @JoinTable(
      name = "property_amenity_lookup",
      joinColumns = @JoinColumn(name = "PROPERTY_ID"),
      inverseJoinColumns = @JoinColumn(name = "AMENITY_ID")
    )
    @JsonManagedReference
    @Fetch(FetchMode.JOIN)
    private Set<Amenity> amenities;

    public Property() {
        this.setPropertySource("");
    }

    public Property(String propertySource) {
        this.propertySource = propertySource;
    }

    public String getPropertySource() {
        return propertySource;
    }

    public void setPropertySource(String propertySource) {
        this.propertySource = propertySource;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Amenity> getAmenities() {
        return amenities;
    }

    public void setAmenities(
      Set<Amenity> amenities) {
        this.amenities = amenities;
    }

    public PropertyDetails getPropertyDetails() {
        return propertyDetails;
    }

    public void setPropertyDetails(
      PropertyDetails propertyDetails) {
        this.propertyDetails = propertyDetails;
    }


}
