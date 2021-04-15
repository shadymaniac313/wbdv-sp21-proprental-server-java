package com.example.wbdvsp21proprentalserverjava.services;

import com.example.wbdvsp21proprentalserverjava.models.Listing;
import com.example.wbdvsp21proprentalserverjava.models.User;
import com.example.wbdvsp21proprentalserverjava.repositiories.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListingService {
    @Autowired
    private ListingRepository repository;

    public Listing fetchListingById(int listingId){
        return repository.findById(listingId).get();
    }
    public List<Listing> fetchAllListings(){
        return (List<Listing>) repository.findAll();
    }
    public  Listing createListing(Listing listing) {
        return repository.save(listing);
    }

    public boolean checkIfExists(int listingId) {
        return this.repository.findById(listingId).isPresent();
    }
}
