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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/listings")
@CrossOrigin(origins = "*")
public class ListingController {

    @Autowired
    ListingService service;
    @Autowired
    UserService userService;
    private Logger logger = LoggerFactory.getLogger(ListingController.class);

    @GetMapping("/all")
    public List<Listing> findAllListings(){
        return service.fetchAllListings();
    }

    @PostMapping("/create")
    public Listing createListing(@RequestBody ListingDTO listingDTO) {
        Listing listingToBeCreated = new Listing(listingDTO.getPropertyId(), listingDTO.getSaleType(),
                listingDTO.getRate(), listingDTO.getAgentId());

        Set<User> embeddedUsers = performUserUpdates(listingDTO.getuserIds());
        listingToBeCreated.setUsers(embeddedUsers);
        return this.service.createListing(listingToBeCreated);
    }

    private Set<User> performUserUpdates(String listingIds) {
        HashSet<User> updatedUsers = new HashSet<>();
        for (String listingId : listingIds.split(" ")) {
            if (this.service.checkIfExists(Integer.parseInt(listingId))) {
                updatedUsers
                        .add(this.userService.fetchUserById(Integer.parseInt(listingId)));
            }
        }
        return updatedUsers;
    }
    @GetMapping("/{id}")
    public Listing findListingForId(@PathVariable int id){
        return service.fetchListingById(id);
    }
}
