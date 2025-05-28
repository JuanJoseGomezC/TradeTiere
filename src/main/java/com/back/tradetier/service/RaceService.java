package com.back.tradetier.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.back.tradetier.dto.RaceDto;
import com.back.tradetier.dto.UpdateRaceDto;
import com.back.tradetier.model.Language;
import com.back.tradetier.model.Race;
import com.back.tradetier.model.Specie;
import com.back.tradetier.repository.LanguageRepository;
import com.back.tradetier.repository.RaceRepository;
import com.back.tradetier.repository.SpecieRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RaceService {

    private final RaceRepository raceRepository;
    private final SpecieRepository specieRepository;
    private final LanguageRepository languageRepository;

    public List<RaceDto> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    public RaceDto getById() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    public RaceDto createRace(RaceDto race) {
        Specie specie = specieRepository.findById(race.getSpecie())
                .orElseThrow(() -> new IllegalArgumentException("Especie no encontrada"));
        Language language = languageRepository.findById(race.getLanguage())
                .orElseThrow(() -> new IllegalArgumentException("Lenguaje no encontrado"));

        return toDto(raceRepository.save(toEntity(race, specie, language)));
    }

    public UpdateRaceDto updateRace(Integer id, UpdateRaceDto race) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateRace'");
    }

    public void createRace(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createRace'");
    }

    public void deleteRace(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteRace'");
    }
    public static Race toEntity(RaceDto race, Specie specie, Language language) {
        return Race.builder()
                .name(race.getName())
                .specie(specie)
                .language(language)
                .build();
    }

    public static RaceDto toDto(Race entity) {
        return RaceDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .specie(entity.getSpecie().getId())
                .language(entity.getLanguage().getId())
                .build();
    }

}
