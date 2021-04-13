package com.example.wbdvsp21proprentalserverjava.services;

import com.example.wbdvsp21proprentalserverjava.models.Property;
import com.example.wbdvsp21proprentalserverjava.repositiories.PropertyRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository repository;

    public List<Property> fetchAllProperties() {
        return (List<Property>) this.repository.findAll();
    }

}
