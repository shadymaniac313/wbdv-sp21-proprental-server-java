package com.example.wbdvsp21proprentalserverjava.controllers;

import com.example.wbdvsp21proprentalserverjava.dtos.PropertyDTO;
import com.example.wbdvsp21proprentalserverjava.models.Amenity;
import com.example.wbdvsp21proprentalserverjava.models.Property;
import com.example.wbdvsp21proprentalserverjava.models.PropertyDetails;
import com.example.wbdvsp21proprentalserverjava.services.AmenityService;
import com.example.wbdvsp21proprentalserverjava.services.PropertyService;
import java.util.HashSet;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/properties")
@CrossOrigin(origins = "*")
public class PropertyController {

    @Autowired
    PropertyService service;
    @Autowired
    private AmenityService amenityService;
    private Logger logger = LoggerFactory.getLogger(PropertyController.class);

    @GetMapping("/all")
    public List<Property> findAllProperties() {
        return service.fetchAllProperties();
    }

    @GetMapping("/state/{state}")
    public List<Property> findPropertiesByState(@PathVariable String state) {
        return this.service.fetchPropertiesByState(state);
    }

    @GetMapping("/city/{city}")
    public List<Property> findPropertiesByCity(@PathVariable String city) {
        return this.service.fetchPropertiesByCity(city);
    }

    @GetMapping("/source/{source}")
    public List<Property> findPropertiesBySource(@PathVariable String source) {
        return this.service.fetchPropertiesBySource(source);
    }

    @PostMapping("/create")
    public Property createProperty(@RequestBody PropertyDTO propertyDTO) {
        Property propertyToBeAdded = new Property(propertyDTO.getSource());
        PropertyDetails embeddedDetails = PropertyDetails.getBuilder()
          .setCity(propertyDTO.getCity())
          .setState(propertyDTO.getState())
          .setZipcode(propertyDTO.getZipcode())
          .build();
        embeddedDetails.setProperty(propertyToBeAdded);
        propertyToBeAdded.setPropertyDetails(embeddedDetails);
        HashSet<Amenity> embeddedAmenities = new HashSet<>();
        String[] amenityIds = propertyDTO.getAmenityIds().split(",");
        for (String amenityId : amenityIds) {
            if (this.amenityService.checkIfExists(Integer.parseInt(amenityId))) {
                embeddedAmenities
                  .add(this.amenityService.findAmenityById(Integer.parseInt(amenityId)));
            }
        }
        propertyToBeAdded.setAmenities(embeddedAmenities);
        return this.service.addProperty(propertyToBeAdded);
    }

}
