package com.example.wbdvsp21proprentalserverjava.controllers;

import com.example.wbdvsp21proprentalserverjava.dtos.UserDTO;
import com.example.wbdvsp21proprentalserverjava.models.User;
import com.example.wbdvsp21proprentalserverjava.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("/api/users")
    public List<User> findAllUsers() {
        return service.fetchAllUsers();
    }

    @PostMapping("/api/users")
    public User createUser(@RequestBody UserDTO userDTO) {
        return service.createUser(new User(userDTO.getFirstName(), userDTO.getLastName(),
          userDTO.getPhone(), userDTO.getUserType()));
    }

}
