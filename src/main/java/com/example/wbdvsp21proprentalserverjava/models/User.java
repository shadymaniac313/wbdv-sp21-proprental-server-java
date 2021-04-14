package com.example.wbdvsp21proprentalserverjava.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int userId;
    private String firstName;
    private String lastName;
    private String phone;
    private int userType;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    @JsonManagedReference
    private UserAuth userAuth;

    @ManyToMany(mappedBy = "users", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Listing> listings;



    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public void setUserAuth(UserAuth userAuth) {
        this.userAuth = userAuth;
    }


    public User() {}

    public User(String firstName, String lastName, String phone, int userType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.userType = userType;
    }

    public int getUserId() {
        return userId;
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

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Set<Listing> getListings() {
        return listings;
    }

    public void setListings(Set<Listing> listings) {
        this.listings = listings;
    }

    public UserAuth getUserAuth() {
        return userAuth;
    }

    @Override
    public String toString() {
        return "User{" +
          "userId=" + userId +
          ", firstName='" + firstName + '\'' +
          ", lastName='" + lastName + '\'' +
          ", phone='" + phone + '\'' +
          ", userType=" + userType +
          '}';
    }
}
