package com.ardent.mailorderpharmacy.controllers;

import com.ardent.mailorderpharmacy.exceptions.LocationNotFoundException;
import com.ardent.mailorderpharmacy.models.Location;
import com.ardent.mailorderpharmacy.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/locations")
public class LocationController {
    private LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping
    public ResponseEntity<Location> addLocation(@RequestBody Location location) {
        Location savedLocation = locationService.addLocation(location);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedLocation);
    }

    @GetMapping
    public ResponseEntity<List<Location>> getAllLocations() {
        List<Location> locations = locationService.getAllLocations();
        return ResponseEntity.ok(locations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Location> getLocationById(@PathVariable Long id) {
        Optional<Location> location = locationService.getLocationById(id);
        return location
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new LocationNotFoundException("Location not found with ID: " + id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Location>> getLocationByZipcode(@RequestParam String zipcode) {
        List<Location> locations = locationService.getLocationByZipcode(zipcode);
        if(locations.isEmpty()) {
            throw new LocationNotFoundException("Location not found with zipcode: " + zipcode);
        }
        return ResponseEntity.ok(locations);
    }
}
