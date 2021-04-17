package com.example.wbdvsp21proprentalserverjava.repositiories;
import com.example.wbdvsp21proprentalserverjava.models.Listing;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ListingRepository extends CrudRepository<Listing, Integer> {

    @Query(value = "select * from listings l where l.ID in (select ul.LISTING_ID from "
      + "user_listing_lookup ul where ul.USER_ID = :userId)", nativeQuery = true)
    List<Listing> findListingsForUser(@Param("userId") int userId);

}
