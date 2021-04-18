package com.example.wbdvsp21proprentalserverjava.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "listings")
public class Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int listingId;

    private int propertyId;
    private String saleType;
    private double rate;
    private int agentId;


    @ManyToMany
    @JoinTable(
      name = "user_listing_lookup",
      joinColumns = {@JoinColumn(name = "LISTING_ID")},
      inverseJoinColumns = {@JoinColumn(name = "USER_ID")}
    )
    @JsonBackReference
    @Fetch(FetchMode.JOIN)
    private Set<User> users;


    public Listing(int propertyId, String saleType, double rate, int agentId) {
        this.propertyId = propertyId;
        this.saleType = saleType;
        this.rate = rate;
        this.agentId = agentId;
    }

    public Listing() {

    }

    public void setListingId(int listingId) {
        this.listingId = listingId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public void setSaleType(String saleType) {
        this.saleType = saleType;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    public int getListingId() {
        return listingId;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public String getSaleType() {
        return saleType;
    }

    public double getRate() {
        return rate;
    }

    public int getAgentId() {
        return agentId;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Listing{" +
          "listingId=" + listingId +
          ", propertyId=" + propertyId +
          ", saleType='" + saleType + '\'' +
          ", rate=" + rate +
          ", agentId=" + agentId +
          '}';
    }

}
