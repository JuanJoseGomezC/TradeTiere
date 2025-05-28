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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    public SpecieDto getById() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    public SpecieDto createSpecie(SpecieDto specie) {
        Language language = languageRepository.findById(specie.getLanguage())
                .orElseThrow(() -> new IllegalArgumentException("Language no encontrado con ID: " + specie.getLanguage()));

        return toDto(specieRepository.save(toEntity(specie, language)));

    }

    public UpdateSpecieDto updateSpecie(Integer id, UpdateSpecieDto specie) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateSpecie'");
    }

    public void deleteSpecie(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteSpecie'");
    }


    public static Specie toEntity(SpecieDto dto, Language language) {
        return Specie.builder()
                .name(dto.getName())
                .language(language)
                .build();
    }

    public static SpecieDto toDto(Specie entity) {
        return SpecieDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .language(entity.getLanguage().getId())
                .build();
    }
}
