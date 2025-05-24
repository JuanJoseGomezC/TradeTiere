package com.back.tradetier.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.tradetier.dto.AdvertisementDto;
import com.back.tradetier.dto.UpdateAdvertisementDto;
import com.back.tradetier.service.AdvertisementService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/api/v1/adverstisement")
@RestController
@RequiredArgsConstructor
public class AdvertisementController {

    private final AdvertisementService advertisementService;

    @GetMapping()
    public List<AdvertisementDto> getAll(){
        return advertisementService.getAllAdvertisements();

            // get all by location

            // get all by specie

            //  get all by race

    };

    @GetMapping("/{id}")
    public AdvertisementDto getById(@PathVariable Integer id){
        return advertisementService.getAdvertisementById(id);
    }

    @PostMapping()
    public AdvertisementDto createAdvertisement(@RequestBody @Valid AdvertisementDto advertisement){
        return advertisementService.createAdvertisement(advertisement);
    }

    @PutMapping()
    public UpdateAdvertisementDto updateAdvertisement(@PathVariable Integer id, @RequestBody UpdateAdvertisementDto advertisement){
        return advertisementService.updateAdvertisement(id, advertisement);

    }

    @DeleteMapping("/{id}")
    public void deleteAdvertisement(@PathVariable Integer id){
        advertisementService.deleteAdvertisement(id);
    }

    // get all by mail



}
