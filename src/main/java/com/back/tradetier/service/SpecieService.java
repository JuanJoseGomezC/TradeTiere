package com.back.tradetier.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.back.tradetier.dto.SpecieDto;
import com.back.tradetier.dto.UpdateSpecieDto;
import com.back.tradetier.model.Language;
import com.back.tradetier.model.Specie;
import com.back.tradetier.repository.LanguageRepository;
import com.back.tradetier.repository.SpecieRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SpecieService {

    private final SpecieRepository specieRepository;
    private final LanguageRepository languageRepository;
    public List<SpecieDto> getAll() {
        return specieRepository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    public SpecieDto getById(Integer id) {
        return specieRepository.findById(id)
                .map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Especie no encontrada con ID: " + id));

    }

    public SpecieDto createSpecie(SpecieDto specie) {
        Language language = languageRepository.findById(specie.getLanguage())
                .orElseThrow(() -> new IllegalArgumentException("Language no encontrado con ID: " + specie.getLanguage()));
        return toDto(specieRepository.save(toEntity(specie, language)));

    }

    public UpdateSpecieDto updateSpecie(Integer id, UpdateSpecieDto specie) {
        Specie existingSpecie = specieRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Especie no encontrada con ID: " + id));

        existingSpecie.setName(specie.getName());

        if (!specie.getLanguage().equals(existingSpecie.getLanguage().getId())) {
            Language language = languageRepository.findById(specie.getLanguage())
                    .orElseThrow(() -> new IllegalArgumentException("Language no encontrado con ID: " + specie.getLanguage()));
            existingSpecie.setLanguage(language);
        }

        return toUpdateDto(specieRepository.save(existingSpecie));
    }

    public void deleteSpecie(Integer id) {
        if (!specieRepository.existsById(id)) {
            throw new IllegalArgumentException("Especie no encontrada con ID: " + id);
        }
        specieRepository.deleteById(id);
    }


    public Specie toEntity(SpecieDto dto, Language language) {
        return Specie.builder()
                .name(dto.getName())
                .language(language)
                .build();
    }

    public SpecieDto toDto(Specie entity) {
        return SpecieDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .language(entity.getLanguage().getId())
                .build();
    }

    public UpdateSpecieDto toUpdateDto(Specie entity) {
        return UpdateSpecieDto.builder()
                .name(entity.getName())
                .language(entity.getLanguage().getId())
                .build();
    }
}
