package com.example.wbdvsp21proprentalserverjava.controllers;

import com.example.wbdvsp21proprentalserverjava.models.Property;
import com.example.wbdvsp21proprentalserverjava.services.PropertyService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/properties")
@CrossOrigin(origins = "*")
public class PropertyController {

    @Autowired
    PropertyService service;
    private Logger logger = LoggerFactory.getLogger(PropertyController.class);

    @GetMapping("/all")
    public List<Property> findAllProperties() {
        return service.fetchAllProperties();
    }

}
