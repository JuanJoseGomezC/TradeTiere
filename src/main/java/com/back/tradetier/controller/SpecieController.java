package com.back.tradetier.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.tradetier.dto.SpecieDto;
import com.back.tradetier.dto.UpdateSpecieDto;
import com.back.tradetier.service.SpecieService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/api/v1/specie")
@RestController
@RequiredArgsConstructor
public class SpecieController {

    private final SpecieService specieService;

        @GetMapping()
    public ResponseEntity<List<SpecieDto>> getAll(){
        return ResponseEntity.ok(specieService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpecieDto> getById(@PathVariable Integer id){
        return ResponseEntity.ok(specieService.getById(id));
    }

    @PostMapping()
    public ResponseEntity<SpecieDto> createSpecie(@RequestBody @Valid SpecieDto specie){
        return ResponseEntity.ok(specieService.createSpecie(specie));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateSpecieDto> updateSpecie(@PathVariable Integer id, @RequestBody UpdateSpecieDto specie){
        return ResponseEntity.ok(specieService.updateSpecie(id, specie));
    }

    @DeleteMapping("/{id}")
    public void deleteSpecie(@PathVariable Integer id){
        specieService.deleteSpecie(id);
    }
}
