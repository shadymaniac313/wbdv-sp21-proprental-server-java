package com.example.wbdvsp21proprentalserverjava.dtos;

public class UserDTO {

    private String firstName;
    private String lastName;
    private String phone;
    private int userType;
    private String username;
    private String password;

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

    public String getPassword() {
        return password;
    }

    public UserDTO(String firstName, String lastName, String phone, int userType,
      String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.userType = userType;
        this.username = username;
        this.password = password;
    }
}
