package com.example.wbdvsp21proprentalserverjava.repositiories;

import com.example.wbdvsp21proprentalserverjava.models.Property;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PropertyRepository extends CrudRepository<Property, Integer> {

    @Query(value = "select * from properties p join property_details pd on p.id = "
      + "pd.property_id where STATE = ?1", nativeQuery = true)
    List<Property> findPropertiesByState(String state);

    @Query(value = "select * from properties p join property_details pd on p.id = "
      + "pd.property_id where CITY = ?1", nativeQuery = true)
    List<Property> findPropertiesByCity(String city);

    @Query(value = "select * from listings l join property_details pd on l.property_id = pd.property_id where l.id = ?1", nativeQuery = true)
    List<Property> findPropertiesByListing(String id);

    List<Property> findPropertiesByPropertySource(String source);

}
