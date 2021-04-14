package com.example.wbdvsp21proprentalserverjava.dtos;

public class PropertyDTO {

    private String source;
    private String city;
    private String state;
    private String zipcode;
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

    public PropertyDTO(String source, String city, String state, String zipcode,
      String amenityIds) {
        this.source = source;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.amenityIds = amenityIds;
    }
}
