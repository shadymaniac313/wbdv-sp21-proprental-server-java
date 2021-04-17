package com.example.wbdvsp21proprentalserverjava.dtos;

public class UserListingDTO {

    private int userId;

    private int listingId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getListingId() {
        return listingId;
    }

    public void setListingId(int listingId) {
        this.listingId = listingId;
    }

    public UserListingDTO(int userId, int listingId) {
        this.userId = userId;
        this.listingId = listingId;
    }
}
