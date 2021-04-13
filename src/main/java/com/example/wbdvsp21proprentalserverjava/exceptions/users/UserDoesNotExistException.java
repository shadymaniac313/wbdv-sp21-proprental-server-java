package com.example.wbdvsp21proprentalserverjava.exceptions.users;

public class UserDoesNotExistException extends IllegalArgumentException {

    public UserDoesNotExistException(String s) {
        super(s);
    }
}
