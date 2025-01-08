package com.ardent.mailorderpharmacy.services.impl;

import com.ardent.mailorderpharmacy.models.Location;
import com.ardent.mailorderpharmacy.repositories.LocationRepository;
import com.ardent.mailorderpharmacy.services.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {
    private LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }
    @Override
    public Location addLocation(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    @Override
    public Optional<Location> getLocationById(Long id) {
        return locationRepository.findById(id);
    }

    @Override
    public List<Location> getLocationByZipcode(String zipcode) {
        return locationRepository.findByZipcode(zipcode);
    }
}
