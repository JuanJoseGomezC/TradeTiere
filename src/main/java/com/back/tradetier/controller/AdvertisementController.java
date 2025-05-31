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
    public ResponseEntity<List<AdvertisementDto>> getAll(){
        return ResponseEntity.ok(advertisementService.getAllAdvertisements());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdvertisementDto> getById(@PathVariable Integer id){
        return ResponseEntity.ok(advertisementService.getAdvertisementById(id));
    }

    @GetMapping("/{email}")
    public ResponseEntity<List<AdvertisementDto>> getAllByMail(@PathVariable String mail) {
        return ResponseEntity.ok(advertisementService.getAllAdvertisementsByMail(mail));
    }


    @PostMapping()
    public ResponseEntity<AdvertisementDto> createAdvertisement(@RequestBody @Valid AdvertisementDto advertisement){
        return ResponseEntity.ok(advertisementService.createAdvertisement(advertisement));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateAdvertisementDto> updateAdvertisement(@PathVariable Integer id, @RequestBody UpdateAdvertisementDto advertisement){
        return ResponseEntity.ok(advertisementService.updateAdvertisement(id, advertisement));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdvertisement(@PathVariable Integer id){
        advertisementService.deleteAdvertisement(id);
        return ResponseEntity.noContent().build();
    }

}