package com.back.tradetier.service;

import java.sql.Date;
import java.util.Base64;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.back.tradetier.config.security.SecurityUtils;
import com.back.tradetier.dto.AdvertismentDto;
import com.back.tradetier.dto.ImageDto;
import com.back.tradetier.dto.LocationDto;
import com.back.tradetier.dto.RaceDto;
import com.back.tradetier.dto.SpecieDto;
import com.back.tradetier.dto.UpdateAdvertismentDto;
import com.back.tradetier.exceptions.AdvertismentNotFoundException;
import com.back.tradetier.model.Advertisment;
import com.back.tradetier.model.Image;
import com.back.tradetier.model.Language;
import com.back.tradetier.model.Location;
import com.back.tradetier.model.Race;
import com.back.tradetier.model.Specie;
import com.back.tradetier.model.User;
import com.back.tradetier.repository.AdvertismentRepository;
import com.back.tradetier.repository.ImageRepository;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AdvertismentService {

    private final SecurityUtils securityUtils;
    private final AdvertismentRepository advertismentRepository;
    private final ImageRepository imageRepository;

    static final String AD_NOT_FOUND = "Anuncio no encontrado con id: ";

    @Transactional(readOnly = true)
    public List<AdvertismentDto> getAllAdvertisments() {
        log.info("Fetching all advertisments");
        return advertismentRepository.findAll().stream()
                .map(this::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public AdvertismentDto getAdvertismentById(Integer id) {
        log.info("Fetching advertisment with id: {}", id);
        return advertismentRepository.findById(id)
                .map(this::toDto)
                .orElseThrow(() -> new AdvertismentNotFoundException(AD_NOT_FOUND + id));
    }

    @Transactional(readOnly = true)
    public List<AdvertismentDto> getAllAdvertismentsByMail(String mail) {
        log.info("Fetching advertisments for user with email: {}", mail);
        return advertismentRepository.findAllByUserMail(mail).stream()
                .map(this::toDto)
                .toList();
    }

    public AdvertismentDto createAdvertisment(@Valid AdvertismentDto advertismentDto) {
        log.info("Creating new advertisment: {}", advertismentDto.getTitle());

        Advertisment advertisment = toAdvertisment(advertismentDto);
        // Set default values
        advertisment.setState(true); // Default state is true
        Advertisment savedAdvertisment = advertismentRepository.save(advertisment);

        log.info("Advertisment saved successfully with id: {}", savedAdvertisment.getId());
        return toDto(savedAdvertisment);
    }

    public void deleteAdvertisment(Integer id) {
        log.info("Deleting advertisment with id: {}", id);
        Advertisment advertisment = advertismentRepository.findById(id)
                .orElseThrow(() -> new AdvertismentNotFoundException(AD_NOT_FOUND + id));
        advertismentRepository.delete(advertisment);
        log.info("Advertisment deleted successfully");
    }

    public UpdateAdvertismentDto updateAdvertisment(Integer id, @Valid UpdateAdvertismentDto updateDto) {
        log.info("Updating advertisment with id: {}", id);
        Advertisment existingAdvertisment = advertismentRepository.findById(id)
                .orElseThrow(() -> new AdvertismentNotFoundException(AD_NOT_FOUND + id));

        // Update only non-null fields
        if (updateDto.getTitle() != null) {
            existingAdvertisment.setTitle(updateDto.getTitle());
        }
        if (updateDto.getDescription() != null) {
            existingAdvertisment.setDescription(updateDto.getDescription());
        }
        if (updateDto.getLocation() != null) {
            existingAdvertisment.setLocation(Location.builder().id(updateDto.getLocation()).build());
        }
        if (updateDto.getSpecie() != null) {
            existingAdvertisment.setSpecie(Specie.builder().id(updateDto.getSpecie()).build());
        }
        if (updateDto.getRace() != null) {
            existingAdvertisment.setRace(Race.builder().id(updateDto.getRace()).build());
        }
        if (updateDto.getBirthdate() != null) {
            // Convertir LocalDate a java.sql.Date
            existingAdvertisment.setBirthdate(Date.valueOf(updateDto.getBirthdate()));
        }
        if (updateDto.getLanguage() != null) {
            existingAdvertisment.setLanguage(Language.builder().id(updateDto.getLanguage()).build());
        }
        if (updateDto.getGender() != null) {
            existingAdvertisment.setGender(updateDto.getGender());
        }
        if (updateDto.getPrice() != null) {
            existingAdvertisment.setPrice(updateDto.getPrice().floatValue());
        }

        advertismentRepository.save(existingAdvertisment);
        log.info("Advertisment updated successfully");
        return updateDto; // Devolvemos el DTO de actualización ya que no es necesario convertir de nuevo
    }
public Advertisment toAdvertisment(AdvertismentDto dto) {
    User user = securityUtils.getCurrentUser();

    // Imagen
    Image image = null;
    if (dto.getImage() != null && dto.getImage().getImageBase64() != null && !dto.getImage().getImageBase64().isEmpty()) {
        byte[] imageData = Base64.getDecoder().decode(dto.getImage().getImageBase64());

        image = Image.builder()
                .imageData(imageData)
                .name(dto.getImage().getName())
                .contentType(dto.getImage().getContentType())
                .build();
    }

    // Location
    Location location = null;
    if (dto.getLocation() != null) {
        location = Location.builder()
                .id(dto.getLocation().getId())
                .build();
    }

    // Specie
    Specie specie = null;
    if (dto.getSpecie() != null) {
        specie = Specie.builder()
                .id(dto.getSpecie().getId())
                .build();
    }

    // Race
    Race race = null;
    if (dto.getRace() != null) {
        race = Race.builder()
                .id(dto.getRace().getId())
                .build();
    }

    // Language
    Language language = null;
    if (dto.getLanguage() != null) {
        language = Language.builder()
                .id(dto.getLanguage())
                .build();
    }

    return Advertisment.builder()
            .user(user)
            .title(dto.getTitle())
            .description(dto.getDescription())
            .location(location)
            .specie(specie)
            .race(race)
            .birthdate(dto.getBirthdate())
            .language(language)
            .image(image)
            .price(dto.getPrice())
            .state(dto.getState())
            .gender(dto.getGender())
            .build();
}


public AdvertismentDto toDto(Advertisment advertisment) {
    // Imagen
    ImageDto imageDto = null;
    if (advertisment.getImage() != null) {
        imageDto = ImageDto.builder()
                .imageBase64(Base64.getEncoder().encodeToString(advertisment.getImage().getImageData()))
                .name(advertisment.getImage().getName())
                .contentType(advertisment.getImage().getContentType())
                .build();
    }

    // Location

    LocationDto locationDto = null;
    if (advertisment.getLocation() != null) {
        Integer locationLanguageId = advertisment.getLocation().getLanguage() != null
                ? advertisment.getLocation().getLanguage().getId()
                : null;

        locationDto = LocationDto.builder()
                .id(advertisment.getLocation().getId())
                .name(advertisment.getLocation().getName())
                .language(locationLanguageId)
                .build();
    }

    // Specie
    SpecieDto specieDto = null;
    if (advertisment.getSpecie() != null) {
        Integer specieLanguageId = advertisment.getSpecie().getLanguage() != null
                ? advertisment.getSpecie().getLanguage().getId()
                : null;

        specieDto = SpecieDto.builder()
                .id(advertisment.getSpecie().getId())
                .name(advertisment.getSpecie().getName())
                .language(specieLanguageId)
                .build();
    }

    // Race
    RaceDto raceDto = null;
    if (advertisment.getRace() != null) {
        Integer raceLanguageId = advertisment.getRace().getLanguage() != null
                ? advertisment.getRace().getLanguage().getId()
                : null;

        Integer raceSpecieId = advertisment.getRace().getSpecie() != null
                ? advertisment.getRace().getSpecie().getId()
                : null;

        raceDto = RaceDto.builder()
                .id(advertisment.getRace().getId())
                .name(advertisment.getRace().getName())
                .language(raceLanguageId)
                .specie(raceSpecieId)
                .build();
    }

    // Language
    Integer languageId = advertisment.getLanguage() != null ? advertisment.getLanguage().getId() : null;

    return AdvertismentDto.builder()
            .id(advertisment.getId())
            .title(advertisment.getTitle())
            .description(advertisment.getDescription())
            .location(locationDto)
            .specie(specieDto)
            .race(raceDto)
            .birthdate(advertisment.getBirthdate())
            .language(languageId)
            .gender(advertisment.getGender())
            .price(advertisment.getPrice())
            .image(imageDto)
            .state(advertisment.getState())
            .userId(advertisment.getUser().getId())
            .build();
}


}