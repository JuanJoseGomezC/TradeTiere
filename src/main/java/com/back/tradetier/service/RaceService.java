package com.back.tradetier.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.back.tradetier.controller.RaceController;
import com.back.tradetier.dto.RaceDto;
import com.back.tradetier.dto.UpdateRaceDto;
import com.back.tradetier.repository.RaceRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RaceService {

    private final RaceRepository raceRepository;

    public List<RaceDto> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    public RaceDto getById() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    public RaceController createRace(RaceDto race) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createRace'");
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


}
