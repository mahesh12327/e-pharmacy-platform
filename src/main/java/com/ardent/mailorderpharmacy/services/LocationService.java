package com.ardent.mailorderpharmacy.services;

import com.ardent.mailorderpharmacy.models.Location;

import java.util.List;
import java.util.Optional;

public interface LocationService {
    Location addLocation(Location location);

    List<Location> getAllLocations();

    Optional<Location> getLocationById(Long id);

    List<Location> getLocationByZipcode(String zipcode);
}
