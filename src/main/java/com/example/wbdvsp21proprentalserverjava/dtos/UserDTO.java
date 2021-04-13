package com.example.wbdvsp21proprentalserverjava.dtos;

public class UserDTO {

    private String firstName;
    private String lastName;
    private String phone;
    private int userType;
    private String username;
    private String pwd;

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

    public String getUsername() {
        return username;
    }

    public String getPwd() {
        return pwd;
    }

    public UserDTO(String firstName, String lastName, String phone, int userType,
      String username, String pwd) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.userType = userType;
        this.username = username;
        this.pwd = pwd;
    }
}
