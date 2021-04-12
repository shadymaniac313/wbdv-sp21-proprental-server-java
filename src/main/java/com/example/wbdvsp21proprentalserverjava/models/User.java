package com.example.wbdvsp21proprentalserverjava.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@SecondaryTable(name = "auth", pkJoinColumns = @PrimaryKeyJoinColumn(name = "USER_ID"))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String firstName;
    private String lastName;
    private String phone;
    private int userType;

    @Column(name = "USERNAME", table = "auth")
    String username;

    @Column(name = "PWD", table = "auth")
    String password;

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
