package com.back.tradetier.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.back.tradetier.dto.LocationDto;
import com.back.tradetier.dto.UpdateLocationDto;
import com.back.tradetier.dto.UpdatePurchaseHistoryDto;
import com.back.tradetier.model.Language;
import com.back.tradetier.model.Location;
import com.back.tradetier.repository.LanguageRepository;
import com.back.tradetier.repository.LocationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LocationService {

    public final LanguageRepository languageRepository;
    public final LocationRepository locationRepository;


    public List<LocationDto> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    public LocationDto getById() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    public LocationDto createLocation(LocationDto location) {
        Language language = languageRepository.findById(location.getLanguage())
                .orElseThrow(() -> new IllegalArgumentException("Language no encontrado"));
        return toDto(locationRepository.save(toEntity(location, language)));
    }

    public UpdateLocationDto updateLocation(Integer id, UpdatePurchaseHistoryDto location) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateLocation'");
    }

    public void deleteLocation(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteLocation'");
    }

        public static Location toEntity(LocationDto dto, Language language) {
        return Location.builder()
                .name(dto.getName())
                .language(language)
                .build();
    }

    public static LocationDto toDto(Location entity) {
        return LocationDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .language(entity.getLanguage().getId())
                .build();
    }
}
