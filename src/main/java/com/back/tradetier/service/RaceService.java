package com.back.tradetier.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.back.tradetier.dto.RaceDto;
import com.back.tradetier.dto.UpdateRaceDto;
import com.back.tradetier.exceptions.LanguageNotFoundException;
import com.back.tradetier.exceptions.RaceNotFoundException;
import com.back.tradetier.exceptions.SpecieNotFoundException;
import com.back.tradetier.model.Language;
import com.back.tradetier.model.Race;
import com.back.tradetier.model.Specie;
import com.back.tradetier.repository.LanguageRepository;
import com.back.tradetier.repository.RaceRepository;
import com.back.tradetier.repository.SpecieRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RaceService {

    private final RaceRepository raceRepository;
    private final SpecieRepository specieRepository;
    private final LanguageRepository languageRepository;

    @Transactional()
    public List<RaceDto> getAll() {

        return raceRepository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    public RaceDto getById(Integer id) {
        return raceRepository.findById(id)
                .map(this::toDto)
                .orElseThrow(() -> new RaceNotFoundException("Raza no encontrada con id: " + id));
    }

    public RaceDto createRace(RaceDto race) {
        Specie specie = specieRepository.findById(race.getSpecie())
                .orElseThrow(() -> new SpecieNotFoundException("Especie no encontrada con ID: " + race.getSpecie()));
        Language language = languageRepository.findById(race.getLanguage())
                .orElseThrow(
                        () -> new LanguageNotFoundException("Lenguaje no encontrado con ID: " + race.getLanguage()));

        return toDto(raceRepository.save(toEntity(race, specie, language)));
    }

    public UpdateRaceDto updateRace(Integer id, UpdateRaceDto race) {
        Race existingRace = raceRepository.findById(id)
                .orElseThrow(() -> new RaceNotFoundException("Raza no encontrada con id: " + id));

        existingRace.setName(race.getName());

        if (!race.getLanguage().equals(existingRace.getLanguage().getId())) {
            Language language = languageRepository.findById(race.getLanguage())
                    .orElseThrow(() -> new LanguageNotFoundException(
                            "Lenguaje no encontrado con ID: " + race.getLanguage()));
            existingRace.setLanguage(language);
        }

        if (!race.getSpecie().equals(existingRace.getSpecie().getId())) {
            Specie specie = specieRepository.findById(race.getSpecie())
                    .orElseThrow(
                            () -> new SpecieNotFoundException("Especie no encontrada con ID: " + race.getSpecie()));
            existingRace.setSpecie(specie);
        }

        return toUpdateDto(raceRepository.save(existingRace));
    }

    public void deleteRace(Integer id) {
        if (!raceRepository.existsById(id)) {
            throw new RaceNotFoundException("Raza no encontrada con id: " + id);
        }
        raceRepository.deleteById(id);
    }

    public Race toEntity(RaceDto race, Specie specie, Language language) {
        return Race.builder()
                .name(race.getName())
                .specie(specie)
                .language(language)
                .build();
    }

    public RaceDto toDto(Race entity) {
        return RaceDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .specie(entity.getSpecie().getId())
                .language(entity.getLanguage().getId())
                .build();
    }

    public UpdateRaceDto toUpdateDto(Race entity) {
        return UpdateRaceDto.builder()
                .name(entity.getName())
                .specie(entity.getSpecie().getId())
                .language(entity.getLanguage().getId())
                .build();
    }

    public List<RaceDto> getRacesFromSpecie(Integer specieId) {
        return raceRepository.findBySpecieId(specieId)
                .stream()
                .map(this::toDto)
                .toList();
    }
}
