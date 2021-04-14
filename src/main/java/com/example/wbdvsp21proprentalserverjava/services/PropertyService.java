package com.example.wbdvsp21proprentalserverjava.services;

import com.example.wbdvsp21proprentalserverjava.dtos.PropertyDTO;
import com.example.wbdvsp21proprentalserverjava.models.Amenity;
import com.example.wbdvsp21proprentalserverjava.models.Property;
import com.example.wbdvsp21proprentalserverjava.models.PropertyDetails;
import com.example.wbdvsp21proprentalserverjava.repositiories.PropertyRepository;
import java.util.HashSet;
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

    public List<Property> fetchPropertiesByState(String state) {
        return this.repository.findPropertiesByState(state);
    }

    public List<Property> fetchPropertiesByCity(String city) {
        return this.repository.findPropertiesByCity(city);
    }

    public List<Property> fetchPropertiesBySource(String source) {
        return this.repository.findPropertiesByPropertySource(source);
    }

    public Property addProperty(Property property) {
        return this.repository.save(property);
    }

}
