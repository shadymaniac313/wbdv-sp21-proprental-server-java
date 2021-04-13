package com.example.wbdvsp21proprentalserverjava.models;

import javax.persistence.*;

@Entity
@Table(name = "USER_LISTING_LOOKUP")
public class UserListingLookup {
    public UserListingLookup(int userId, int listingId) {
        this.userId = userId;
        this.listingId = listingId;
    }

    public UserListingLookup() {
    }

    public int getUserId() {
        return userId;
    }

    public int getListingId() {
        return listingId;
    }

    @Override
    public String toString() {
        return "UserListingLookup{" +
                "userId=" + userId +
                ", listingId=" + listingId +
                '}';
    }

    private int userId;
    private int listingId;

}
