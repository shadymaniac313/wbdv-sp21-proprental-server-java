package com.example.wbdvsp21proprentalserverjava.controllers;

import com.example.wbdvsp21proprentalserverjava.dtos.ListingDTO;
import com.example.wbdvsp21proprentalserverjava.dtos.UserDTO;
import com.example.wbdvsp21proprentalserverjava.models.Listing;
import com.example.wbdvsp21proprentalserverjava.models.User;
import com.example.wbdvsp21proprentalserverjava.models.UserAuth;
import com.example.wbdvsp21proprentalserverjava.services.ListingService;
import com.example.wbdvsp21proprentalserverjava.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/listings")
@CrossOrigin(origins = "*")
public class ListingController {

    @Autowired
    ListingService service;
    UserService userService;
    private Logger logger = LoggerFactory.getLogger(ListingController.class);

    @GetMapping("/all")
    public List<Listing> findAllListings(){
        return service.fetchAllListings();
    }

    @PostMapping("/create")
    public User createListing(@RequestBody ListingDTO listingDTO) {
        Listing listingToBeCreated = new Listing(listingDTO.getPropertyId(), listingDTO.getSaleType(),
                listingDTO.getRate(), listingDTO.getAgentId());
        User oldUser = userService.fetchUserById(listingDTO.getUserId());
        Set<Listing> m =(oldUser.getListings().add(listingToBeCreated));
        oldUser.setListings(m);
        listingToBeCreated.setUsers(oldUser);
        return this.service.createListing(listingToBeCreated);
    }

}
