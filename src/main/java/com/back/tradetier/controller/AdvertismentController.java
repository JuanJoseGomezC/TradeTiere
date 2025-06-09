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

import com.back.tradetier.dto.AdvertismentDto;
import com.back.tradetier.dto.UpdateAdvertismentDto;
import com.back.tradetier.service.AdvertismentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/api/v1/advertisment")
@RestController
@RequiredArgsConstructor
public class AdvertismentController {

    private final AdvertismentService advertismentService;

    @GetMapping()
    public ResponseEntity<List<AdvertismentDto>> getAll(){
        return ResponseEntity.ok(advertismentService.getAllAdvertisments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdvertismentDto> getById(@PathVariable Integer id){
        return ResponseEntity.ok(advertismentService.getAdvertismentById(id));
    }

    @GetMapping("/email/{mail}")
    public ResponseEntity<List<AdvertismentDto>> getAllByMail(@PathVariable String mail) {
        return ResponseEntity.ok(advertismentService.getAllAdvertismentsByMail(mail));
    }


    @PostMapping()
    public ResponseEntity<AdvertismentDto> createAdvertisment(@RequestBody @Valid AdvertismentDto advertisment){
        return ResponseEntity.ok(advertismentService.createAdvertisment(advertisment));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateAdvertismentDto> updateAdvertisment(@PathVariable Integer id, @RequestBody UpdateAdvertismentDto advertisment){
        return ResponseEntity.ok(advertismentService.updateAdvertisment(id, advertisment));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdvertisment(@PathVariable Integer id){
        advertismentService.deleteAdvertisment(id);
        return ResponseEntity.noContent().build();
    }

}