package com.example.wbdvsp21proprentalserverjava.controllers;

import com.example.wbdvsp21proprentalserverjava.dtos.PropertyDTO;
import com.example.wbdvsp21proprentalserverjava.models.Amenity;
import com.example.wbdvsp21proprentalserverjava.models.Property;
import com.example.wbdvsp21proprentalserverjava.models.PropertyDetails;
import com.example.wbdvsp21proprentalserverjava.services.AmenityService;
import com.example.wbdvsp21proprentalserverjava.services.PropertyService;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
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

    @GetMapping("/{id}")
    public Optional<Property> findPropertiesBySource(@PathVariable int id) {
        return this.service.fetchPropertyById(id);
    }

    @PostMapping("/create")
    public Property createProperty(@RequestBody PropertyDTO propertyDTO) {
        Property propertyToBeAdded = new Property(propertyDTO.getSource());
        PropertyDetails embeddedDetails = PropertyDetails.getBuilder()
          .setCity(propertyDTO.getCity())
          .setState(propertyDTO.getState())
          .setZipcode(propertyDTO.getZipcode())
          .setBathCount(propertyDTO.getBathCount())
          .setBedCount(propertyDTO.getBedCount())
          .setAreaSqFt(propertyDTO.getAreaSqFt())
          .build();
        embeddedDetails.setProperty(propertyToBeAdded);
        propertyToBeAdded.setPropertyDetails(embeddedDetails);
        Set<Amenity> embeddedAmenities = performAmenityUpdates(propertyDTO.getAmenityIds());
        propertyToBeAdded.setAmenities(embeddedAmenities);
        return this.service.addProperty(propertyToBeAdded);
    }

    @PutMapping("/update/{propertyId}")
    public int updateProperty(@PathVariable int propertyId,
      @RequestBody PropertyDTO updatedProperty) {
        Optional<Property> propertyToBeUpdated = this.service.fetchPropertyById(propertyId);
        if (propertyToBeUpdated.isPresent()) {
            Property existingProperty = propertyToBeUpdated.get();
            existingProperty.setPropertySource(updatedProperty.getSource());
            existingProperty.getPropertyDetails().setCity(updatedProperty.getCity());
            existingProperty.getPropertyDetails().setState(updatedProperty.getState());
            existingProperty.getPropertyDetails().setZipcode(updatedProperty.getZipcode());
            existingProperty.getPropertyDetails().setBathCount(updatedProperty.getBathCount());
            existingProperty.getPropertyDetails().setBedCount(updatedProperty.getBedCount());
            existingProperty.getPropertyDetails().setAreaSqFt(updatedProperty.getAreaSqFt());
            Set<Amenity> updatedAmenities = performAmenityUpdates(updatedProperty.getAmenityIds());
            existingProperty.setAmenities(updatedAmenities);
            this.service.addProperty(existingProperty);
            return 1;
        }
        return 0;
    }

    private Set<Amenity> performAmenityUpdates(String amenityIds) {
        HashSet<Amenity> updatedAmenities = new HashSet<>();
        for (String amenityId : amenityIds.split(",")) {
            if (this.amenityService.checkIfExists(Integer.parseInt(amenityId))) {
                updatedAmenities
                  .add(this.amenityService.findAmenityById(Integer.parseInt(amenityId)));
            }
        }
        return updatedAmenities;
    }

    @DeleteMapping("/delete/{propertyId}")
    private void deleteProperty(@PathVariable int propertyId) {
        this.service.deleteProperty(propertyId);
    }

}
