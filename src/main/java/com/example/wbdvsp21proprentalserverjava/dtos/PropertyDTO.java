package com.example.wbdvsp21proprentalserverjava.dtos;

public class PropertyDTO {

    private String source;
    private String city;
    private String state;
    private String zipcode;
    private int bathCount;
    private int bedCount;
    private double areaSqFt;
    private String amenityIds;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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

    public String getAmenityIds() {
        return amenityIds;
    }

    public void setAmenityIds(String amenityIds) {
        this.amenityIds = amenityIds;
    }


    public int getBathCount() {
        return bathCount;
    }

    public void setBathCount(int bathCount) {
        this.bathCount = bathCount;
    }

    public int getBedCount() {
        return bedCount;
    }

    public void setBedCount(int bedCount) {
        this.bedCount = bedCount;
    }

    public double getAreaSqFt() {
        return areaSqFt;
    }

    public void setAreaSqFt(double areaSqFt) {
        this.areaSqFt = areaSqFt;
    }


    public PropertyDTO(String source, String city, String state, String zipcode,
      int bathCount, int bedCount, double areaSqFt, String amenityIds) {
        this.source = source;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.bathCount = bathCount;
        this.bedCount = bedCount;
        this.areaSqFt = areaSqFt;
        this.amenityIds = amenityIds;
    }
}
