package com.back.tradetier.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.back.tradetier.controller.LocationController;
import com.back.tradetier.dto.LocationDto;
import com.back.tradetier.dto.UpdateLocationDto;
import com.back.tradetier.dto.UpdatePurchaseHistoryDto;
import com.back.tradetier.repository.LocationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LocationService {

    public final LocationRepository locationRepository;

    public List<LocationDto> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    public LocationDto getById() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    public LocationController createLocation(LocationDto location) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createLocation'");
    }

    public UpdateLocationDto updateLocation(Integer id, UpdatePurchaseHistoryDto location) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateLocation'");
    }

    public void deleteLocation(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteLocation'");
    }

}
