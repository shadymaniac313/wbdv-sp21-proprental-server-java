package com.example.wbdvsp21proprentalserverjava.dtos;

public class ListingDTO {
    private String userIds;

    private String firstName;
    private String lastName;
    private String phone;
    private int userType;

    private int propertyId;
    private String saleType;
    private double rate;
    private int agentId;

    public ListingDTO(String userIds, String firstName, String lastName, String phone, int userType, int propertyId, String saleType, double rate, int agentId) {
        this.userIds = userIds;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.userType = userType;
        this.propertyId = propertyId;
        this.saleType = saleType;
        this.rate = rate;
        this.agentId = agentId;
    }

    public String getuserIds() {
        return userIds;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public int getUserType() {
        return userType;
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
}
