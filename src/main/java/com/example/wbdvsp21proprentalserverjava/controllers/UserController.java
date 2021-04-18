package com.example.wbdvsp21proprentalserverjava.controllers;

import com.example.wbdvsp21proprentalserverjava.dtos.UserDTO;
import com.example.wbdvsp21proprentalserverjava.dtos.UserListingDTO;
import com.example.wbdvsp21proprentalserverjava.models.Listing;
import com.example.wbdvsp21proprentalserverjava.models.User;
import com.example.wbdvsp21proprentalserverjava.models.UserAuth;
import com.example.wbdvsp21proprentalserverjava.services.ListingService;
import com.example.wbdvsp21proprentalserverjava.services.UserService;
import java.util.List;
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
    UserService userService;
    @Autowired
    ListingService listingService;
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/all")
    public List<User> findAllUsers() {
        return this.userService.fetchAllUsers();
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable int id) {
        return this.service.fetchUserById(id);
    }


    @GetMapping("/authenticate/{username}/{password}")
    public int authenticate(@PathVariable String username, @PathVariable String password) {
        if (userService.checkIfExistsAndAuthenticate(username, password)) {
            return userService.fetchUserByUsername(username).getUserId();
        }
        return 0;
    }

    @PostMapping("/create")
    public User createUser(@RequestBody UserDTO userDTO) {
        User userToBeCreated = new User(userDTO.getFirstName(), userDTO.getLastName(),
          userDTO.getPhone(), userDTO.getUserType());
        UserAuth authToBeCreated = new UserAuth(userDTO.getUsername(), userDTO.getPwd());
        userToBeCreated.setUserAuth(authToBeCreated);
        authToBeCreated.setUser(userToBeCreated);
        return this.userService.createUser(userToBeCreated);
    }

    @PostMapping("/like")
    public User addListingForUser(@RequestBody UserListingDTO userListingDTO) {
        User user = this.userService.fetchUserById(userListingDTO.getUserId());
        Listing listing = this.listingService.fetchListingById(userListingDTO.getListingId());
        user.getListings().add(listing);
        listing.getUsers().add(user);
        return this.userService.updateUser(user);
    }

    @PostMapping("/unlike")
    public User removeListingForUser(@RequestBody UserListingDTO userListingDTO) {
        User user = this.userService.fetchUserById(userListingDTO.getUserId());
        Listing listing = this.listingService.fetchListingById(userListingDTO.getListingId());
        user.getListings().remove(listing);
        listing.getUsers().remove(user);
        return this.userService.updateUser(user);
    }

    @PutMapping(value = "/update/{userId}")
    public User updateUser(@RequestBody UserDTO user, @PathVariable int userId) {
        logger.info("Attempting to update user details");
        return this.userService.updateUser(user, userId);
    }

    @DeleteMapping("/{userId}")
    public int deleteUser(@PathVariable int userId) {
        try {
            logger.info("Attempting to delete user {}", userId);
            this.userService.deleteUser(userId);
        } catch (Exception e) {
            logger.error("User {} being deleted does not exist", userId);
            return 0;
        }
        return 1;
    }

}
