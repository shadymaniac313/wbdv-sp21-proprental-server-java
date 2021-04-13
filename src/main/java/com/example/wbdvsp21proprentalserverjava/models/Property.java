package com.example.wbdvsp21proprentalserverjava.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "properties")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int propertyId;

    private String propertySource;

    public Property(){}

    public Property(String propertySource) {
        this.propertySource = propertySource;
    }

}
