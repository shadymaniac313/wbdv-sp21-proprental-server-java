package com.example.wbdvsp21proprentalserverjava.services;

import com.example.wbdvsp21proprentalserverjava.models.User;
import com.example.wbdvsp21proprentalserverjava.repositiories.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> fetchAllUsers() {
        return (List<User>) repository.findAll();
    }
}
