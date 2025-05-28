package com.back.tradetier.service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.back.tradetier.config.security.JwtService;
import com.back.tradetier.config.security.SecurityUtils;
import com.back.tradetier.dto.AdvertisementDto;
import com.back.tradetier.dto.UpdateAdvertisementDto;
import com.back.tradetier.exceptions.ResourceNotFoundException;
import com.back.tradetier.model.Advertisement;
import com.back.tradetier.model.Language;
import com.back.tradetier.model.Location;
import com.back.tradetier.model.Race;
import com.back.tradetier.model.Specie;
import com.back.tradetier.model.User;
import com.back.tradetier.repository.AdvertisementRepository;
import com.back.tradetier.repository.UserRepository;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class AdvertisementService {

    private static final Logger log = LoggerFactory.getLogger(AdvertisementService.class);

    private final SecurityUtils securityUtils;
    private final AdvertisementRepository advertisementRepository;
    private final JwtService jwtService;
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<AdvertisementDto> getAllAdvertisements() {
        log.info("Fetching all advertisements");
        return advertisementRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public AdvertisementDto getAdvertisementById(Integer id) {
        log.info("Fetching advertisement with id: {}", id);
        return advertisementRepository.findById(id)
                .map(this::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Advertisement not found with id: " + id));
    }

    public AdvertisementDto createAdvertisement(@Valid AdvertisementDto advertisementDto) {
        log.info("Creating new advertisement: {}", advertisementDto.getTitle());
        Advertisement advertisement = toAdvertisement(advertisementDto);
        Advertisement savedAdvertisement = advertisementRepository.save(advertisement);
        log.info("Advertisement saved successfully with id: {}", savedAdvertisement.getId());
        return toDto(savedAdvertisement);
    }

    public void deleteAdvertisement(Integer id) {
        log.info("Deleting advertisement with id: {}", id);
        Advertisement advertisement = advertisementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Advertisement not found with id: " + id));
        advertisementRepository.delete(advertisement);
        log.info("Advertisement deleted successfully");
    }

    public UpdateAdvertisementDto updateAdvertisement(Integer id, @Valid UpdateAdvertisementDto updateDto) {
        log.info("Updating advertisement with id: {}", id);
        Advertisement existingAdvertisement = advertisementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Advertisement not found with id: " + id));

        // Update only non-null fields
        if (updateDto.getTitle() != null) {
            existingAdvertisement.setTitle(updateDto.getTitle());
        }
        if (updateDto.getDescription() != null) {
            existingAdvertisement.setDescription(updateDto.getDescription());
        }
        if (updateDto.getLocation() != null) {
            existingAdvertisement.setLocation(Location.builder().id(updateDto.getLocation()).build());
        }
        if (updateDto.getSpecie() != null) {
            existingAdvertisement.setSpecie(Specie.builder().id(updateDto.getSpecie()).build());
        }
        if (updateDto.getRace() != null) {
            existingAdvertisement.setRace(Race.builder().id(updateDto.getRace()).build());
        }
        if (updateDto.getBirthdate() != null) {
            // Convertir LocalDate a java.sql.Date
            existingAdvertisement.setBirthdate(Date.valueOf(updateDto.getBirthdate()));
        }
        if (updateDto.getLanguage() != null) {
            existingAdvertisement.setLanguage(Language.builder().id(updateDto.getLanguage()).build());
        }
        if (updateDto.getGender() != null) {
            existingAdvertisement.setGender(updateDto.getGender());
        }
        if (updateDto.getPrice() != null) {
            existingAdvertisement.setPrice(updateDto.getPrice().floatValue());
        }

        advertisementRepository.save(existingAdvertisement);
        log.info("Advertisement updated successfully");
        return updateDto; // Devolvemos el DTO de actualización ya que no es necesario convertir de nuevo
    }

    public Advertisement toAdvertisement(AdvertisementDto dto) {
        User user = securityUtils.getCurrentUser();
        return Advertisement.builder()
                .user(user)
                .title(dto.getTitle())
                .description(dto.getDescription())
                .location(Location.builder()
                        .id(dto.getLocation())
                        .build())
                .specie(Specie.builder()
                        .id(dto.getSpecie())
                        .build())
                .race(Race.builder()
                        .id(dto.getRace())
                        .build())
                .birthdate(dto.getBirthdate()) // Ya es java.sql.Date
                .language(Language.builder()
                        .id(dto.getLanguage())
                        .build())
                .gender(dto.getGender())
                .price(dto.getPrice())
                .state(true)
                .build();
    }

    public AdvertisementDto toDto(Advertisement advertisement) {
        return AdvertisementDto.builder()
                .title(advertisement.getTitle())
                .description(advertisement.getDescription())
                .location(advertisement.getLocation() != null ? advertisement.getLocation().getId() : null)
                .specie(advertisement.getSpecie() != null ? advertisement.getSpecie().getId() : null)
                .race(advertisement.getRace() != null ? advertisement.getRace().getId() : null)
                .birthdate(advertisement.getBirthdate()) // Ya es java.sql.Date
                .language(advertisement.getLanguage() != null ? advertisement.getLanguage().getId() : null)
                .gender(advertisement.getGender())
                .price(advertisement.getPrice())
                .build();
    }

}
