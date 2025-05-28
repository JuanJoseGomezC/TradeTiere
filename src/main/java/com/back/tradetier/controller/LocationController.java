package com.back.tradetier.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.tradetier.dto.LocationDto;
import com.back.tradetier.dto.UpdateLocationDto;
import com.back.tradetier.dto.UpdatePurchaseHistoryDto;
import com.back.tradetier.service.LocationService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/api/v1/location")
@RestController
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;

    @GetMapping()
    public List<LocationDto> getAll(){
        return locationService.getAll();
    }

    @GetMapping("/{id}")
    public LocationDto getById(@PathVariable Integer id){
        return locationService.getById();
    }

    @PostMapping()
    public LocationDto createLocation(@RequestBody @Valid LocationDto location){
        return locationService.createLocation(location);
    }

    @PutMapping()
    public UpdateLocationDto updateLocation(@PathVariable Integer id, @RequestBody UpdatePurchaseHistoryDto location){
        return locationService.updateLocation(id, location);
    }

    @DeleteMapping("/{id}")
    public void deleteLocation(@PathVariable Integer id){
        locationService.deleteLocation(id);
    }
}
