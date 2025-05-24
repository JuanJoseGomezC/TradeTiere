package com.back.tradetier.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.tradetier.dto.RaceDto;
import com.back.tradetier.dto.UpdateRaceDto;
import com.back.tradetier.service.RaceService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/api/v1/race")
@RestController
@RequiredArgsConstructor
public class RaceController {

    private final RaceService raceService;

        @GetMapping()
    public List<RaceDto> getAll(){
        return raceService.getAll();
    }

    @GetMapping("/{id}")
    public RaceDto getById(@PathVariable Integer id){
        return raceService.getById();
    }

    @PostMapping()
    public RaceController createRace(@RequestBody @Valid RaceDto race){
        return raceService.createRace(race);
    }

    @PutMapping()
    public UpdateRaceDto updateRace(@PathVariable Integer id, @RequestBody UpdateRaceDto race){
        return raceService.updateRace(id, race);
    }

    @DeleteMapping("/{id}")
    public void deleteRace(@PathVariable Integer id){
        raceService.deleteRace(id);
    }
}
