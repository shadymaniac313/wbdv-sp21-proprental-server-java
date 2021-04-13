package com.example.wbdvsp21proprentalserverjava.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "property_details")
public class PropertyDetails {

    @Id
    @Column(name = "PROPERTY_ID")
    private int propertyId;
    private String city;
    private String state;
    private String zipcode;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "PROPERTY_ID")
    @JsonBackReference
    private Property property;

    public PropertyDetails(){}

    public PropertyDetails(String city, String state, String zipcode) {
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(
      Property property) {
        this.property = property;
    }

}
