package com.back.tradetier.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.back.tradetier.dto.LanguageDto;
import com.back.tradetier.dto.UpdateLanguageDto;
import com.back.tradetier.exceptions.ResourceNotFoundException;
import com.back.tradetier.model.Language;
import com.back.tradetier.repository.LanguageRepository;

import lombok.RequiredArgsConstructor;

/**
 * Service for managing languages.
 */
@Service
@RequiredArgsConstructor
@Transactional
public class LanguageService {

    private static final Logger log = LoggerFactory.getLogger(LanguageService.class);

    private final LanguageRepository languageRepository;

    /**
     * Get all languages.
     *
     * @return list of all languages as DTOs
     */
    @Transactional(readOnly = true)
    public List<LanguageDto> getAll() {
        log.info("Getting all languages");
        return languageRepository.findAll()
                .stream()
                .map(LanguageService::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Get a language by ID.
     *
     * @param id the language ID
     * @return the language DTO
     * @throws ResourceNotFoundException if the language is not found
     */
    @Transactional(readOnly = true)
    public LanguageDto getById(Integer id) {
        log.info("Getting language by id: {}", id);
        return languageRepository.findById(id)
            .map(LanguageService::toDto)
            .orElseThrow(() -> new ResourceNotFoundException("Language not found with id: " + id));
    }

    /**
     * Create a new language.
     *
     * @param languageDto the language DTO
     * @return the created language DTO
     */
    @Transactional
    public LanguageDto createLanguage(LanguageDto languageDto) {
        log.info("Creating new language: {}", languageDto.getLanguage());
        Language language = toEntity(languageDto);
        language = languageRepository.save(language);
        log.info("Language created successfully with id: {}", language.getId());
        return toDto(language);
    }

    /**
     * Update a language by ID.
     *
     * @param id the language ID
     * @param updateLanguageDto the update data
     * @return the update data DTO
     * @throws ResourceNotFoundException if the language is not found
     */
    @Transactional
    public UpdateLanguageDto updateLanguage(Integer id, UpdateLanguageDto updateLanguageDto) {
        log.info("Updating language with id: {}", id);

        Language language = languageRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Language not found with id: " + id));

        // Update language name
        if (updateLanguageDto.getLanguage() != null) {
            language.setLanguage(updateLanguageDto.getLanguage());
        }

        languageRepository.save(language);
        log.info("Language updated successfully");

        return updateLanguageDto;
    }

    /**
     * Delete a language by ID.
     *
     * @param id the language ID
     * @throws ResourceNotFoundException if the language is not found
     */
    @Transactional
    public void deleteLanguage(Integer id) {
        log.info("Deleting language with id: {}", id);

        Language language = languageRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Language not found with id: " + id));

        languageRepository.delete(language);
        log.info("Language deleted successfully");
    }

    /**
     * Convert Language entity to LanguageDto.
     *
     * @param entity the language entity
     * @return the language DTO
     */
    public static LanguageDto toDto(Language entity) {
        return LanguageDto.builder()
                .id(entity.getId())
                .language(entity.getLanguage())
                .build();
    }

    /**
     * Convert LanguageDto to Language entity.
     *
     * @param dto the language DTO
     * @return the language entity
     */
    public static Language toEntity(LanguageDto dto) {
        return Language.builder()
                .language(dto.getLanguage())
                .build();
    }
}
