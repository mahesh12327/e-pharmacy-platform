package com.ardent.mailorderpharmacy.repositories;

import com.ardent.mailorderpharmacy.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    List<Location> findByZipcode(String zipcode);
}
