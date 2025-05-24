package com.back.tradetier.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.back.tradetier.controller.SpecieController;
import com.back.tradetier.dto.SpecieDto;
import com.back.tradetier.dto.UpdateSpecieDto;
import com.back.tradetier.repository.SpecieRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SpecieService {

    private final SpecieRepository specieRepositoy;

    public List<SpecieDto> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    public SpecieDto getById() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    public SpecieController createSpecie(SpecieDto specie) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createSpecie'");
    }

    public UpdateSpecieDto updateSpecie(Integer id, UpdateSpecieDto specie) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateSpecie'");
    }

    public void deleteSpecie(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteSpecie'");
    }



}
