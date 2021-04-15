package com.example.wbdvsp21proprentalserverjava.controllers;

import com.example.wbdvsp21proprentalserverjava.dtos.UserDTO;
import com.example.wbdvsp21proprentalserverjava.models.User;
import com.example.wbdvsp21proprentalserverjava.models.UserAuth;
import com.example.wbdvsp21proprentalserverjava.services.UserService;
import java.util.List;
import javax.xml.ws.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserService service;
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/all")
    public List<User> findAllUsers() {
        return this.service.fetchAllUsers();
    }

    @GetMapping("/authenticate/{username}/{password}")
    public boolean authenticate(@PathVariable String username, @PathVariable String password) {
        return this.service.checkIfExistsAndAuthenticate(username, password);
    }

    @PostMapping("/create")
    public User createUser(@RequestBody UserDTO userDTO) {
        User userToBeCreated = new User(userDTO.getFirstName(), userDTO.getLastName(),
          userDTO.getPhone(), userDTO.getUserType());
        UserAuth authToBeCreated = new UserAuth(userDTO.getUsername(), userDTO.getPwd());
        userToBeCreated.setUserAuth(authToBeCreated);
        authToBeCreated.setUser(userToBeCreated);
        return this.service.createUser(userToBeCreated);
    }

    @PutMapping(value = "/update/{userId}")
    public User updateUser(@RequestBody UserDTO user, @PathVariable int userId) {
        logger.info("Attempting to update user details");
        return this.service.updateUser(user, userId);
    }

    @DeleteMapping("/{userId}")
    public int deleteUser(@PathVariable int userId) {
        try {
            logger.info("Attempting to delete user {}", userId);
            this.service.deleteUser(userId);
        } catch (Exception e) {
            logger.error("User {} being deleted does not exist", userId);
            return 0;
        }
        return 1;
    }

}
