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

import com.back.tradetier.dto.RaceDto;
import com.back.tradetier.dto.UpdateRaceDto;
import com.back.tradetier.service.RaceService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@RequestMapping("/api/v1/race")
@RestController
@RequiredArgsConstructor
public class RaceController {

    private final RaceService raceService;

        @GetMapping()
    public ResponseEntity<List<RaceDto>> getAll(){
        return ResponseEntity.ok(raceService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RaceDto> getById(@PathVariable Integer id){
        return ResponseEntity.ok(raceService.getById(id));
    }

    @PostMapping()
    public ResponseEntity<RaceDto> createRace(@RequestBody @Valid RaceDto race){
        return ResponseEntity.ok(raceService.createRace(race));
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<UpdateRaceDto> updateRace(@PathVariable Integer id, @RequestBody UpdateRaceDto race){
        return ResponseEntity.ok(raceService.updateRace(id, race));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRace(@PathVariable Integer id){
        raceService.deleteRace(id);
        return ResponseEntity.noContent().build();
    }
}
