package com.example.wbdvsp21proprentalserverjava.services;

import com.example.wbdvsp21proprentalserverjava.repositiories.AmenityRepository;
import com.example.wbdvsp21proprentalserverjava.models.Amenity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AmenityService {

    @Autowired
    private AmenityRepository repository;

    public Amenity createAmenity(Amenity amenity) {
        return this.repository.save(amenity);
    }

    public boolean checkIfExists(int amenityId) {
        return this.repository.findById(amenityId).isPresent();
    }

    public Amenity findAmenityById(int id) {
        if(this.checkIfExists(id))
            return this.repository.findById(id).get();
        return null;
    }

}
