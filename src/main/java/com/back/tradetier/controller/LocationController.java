package com.back.tradetier.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.tradetier.dto.LocationDto;
import com.back.tradetier.dto.UpdateLocationDto;
import com.back.tradetier.service.LocationService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/api/v1/location")
@RestController
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;

    @GetMapping()
    public ResponseEntity<List<LocationDto>> getAll(){
        return ResponseEntity.ok(locationService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocationDto> getById(@PathVariable Integer id){
        return ResponseEntity.ok(locationService.getById(id));
    }

    @PostMapping()
    public ResponseEntity<LocationDto> createLocation(@RequestBody @Valid LocationDto location){
        return ResponseEntity.ok(locationService.createLocation(location));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateLocationDto> updateLocation(@PathVariable Integer id, @RequestBody UpdateLocationDto location){
        return ResponseEntity.ok(locationService.updateLocation(id, location));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable Integer id){
        locationService.deleteLocation(id);
        return ResponseEntity.noContent().build();
    }
}
