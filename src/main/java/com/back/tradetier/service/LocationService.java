package com.back.tradetier.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.back.tradetier.dto.LocationDto;
import com.back.tradetier.dto.UpdateLocationDto;
import com.back.tradetier.exceptions.LanguageNotFoundException;
import com.back.tradetier.exceptions.LocationNotFoundException;
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


    public LocationDto createLocation(LocationDto dto) {
        Language language = languageRepository.findById(dto.getLanguage())
            .orElseThrow(() -> new LanguageNotFoundException("Lenguaje no encontrado con ID: " + dto.getLanguage()));

        Location location = Location.builder()
            .name(dto.getName())
            .language(language)
            .build();

        location = locationRepository.save(location);
        return mapToDTO(location);
    }

    public LocationDto getById(Integer id) {
        return locationRepository.findById(id)
            .map(this::mapToDTO)
            .orElseThrow(() -> new LocationNotFoundException("Ubicación no encontrada con ID: " + id));
    }

    public List<LocationDto> getAll() {
        return locationRepository.findAll().stream()
            .map(this::mapToDTO)
            .toList();
    }

    public UpdateLocationDto updateLocation(Integer id, UpdateLocationDto dto) {
        Location existing = locationRepository.findById(id)
            .orElseThrow(() -> new LocationNotFoundException("Ubicación no encontrada con ID: " + id));

        if (!existing.getLanguage().getId().equals(dto.getLanguage())) {
            Language language = languageRepository.findById(dto.getLanguage())
                .orElseThrow(() -> new LanguageNotFoundException("Lenguaje no encontrado con ID: " + dto.getLanguage()));
            existing.setLanguage(language);
        }

        existing.setName(dto.getName());
        Location updated = locationRepository.save(existing);
        return mapToUpdateDTO(updated);
    }

    public void deleteLocation(Integer id) {
        if (!locationRepository.existsById(id)) {
            throw new LocationNotFoundException("Ubicación no encontrada con ID: " + id);
        }
        locationRepository.deleteById(id);
    }

    private UpdateLocationDto mapToUpdateDTO(Location location) {
        return UpdateLocationDto
            .builder()
            .name(location.getName())
            .language(location.getLanguage().getId())
            .build();
    }

    private LocationDto mapToDTO(Location location) {
        return LocationDto
            .builder()
            .id(location.getId())
            .name(location.getName())
            .language(location.getLanguage().getId())
            .build();
    }
}
