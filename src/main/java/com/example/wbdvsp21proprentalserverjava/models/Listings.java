package com.example.wbdvsp21proprentalserverjava.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "LISTINGS")
public class Listings {
    public Listings(int listingId, int propertyId, int agentId, String saleType, double rate) {
        this.listingId = listingId;
        this.propertyId = propertyId;
        this.agentId = agentId;
        this.saleType = saleType;
        this.rate = rate;
    }

    public int getListingId() {
        return listingId;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public int getAgentId() {
        return agentId;
    }

    public String getSaleType() {
        return saleType;
    }

    public double getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return "Listings{" +
                "listingId=" + listingId +
                ", propertyId=" + propertyId +
                ", agentId=" + agentId +
                ", saleType='" + saleType + '\'' +
                ", rate=" + rate +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int listingId, propertyId, agentId;
    private String saleType;
    private double rate;

    public Listings(){}

}
