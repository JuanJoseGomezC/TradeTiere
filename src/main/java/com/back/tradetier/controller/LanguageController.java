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

import com.back.tradetier.dto.LanguageDto;
import com.back.tradetier.dto.UpdateLanguageDto;
import com.back.tradetier.service.LanguageService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@RequestMapping("/api/v1/language")
@RestController
@RequiredArgsConstructor
public class LanguageController {

    private final LanguageService languageService;

    @GetMapping()
    public List<LanguageDto> getAll() {
        return languageService.getAll();
    }

    @GetMapping("/{id}")
    public LanguageDto getById(@PathVariable Integer id){
        return languageService.getById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<LanguageDto> createLanguage(@RequestBody @Valid LanguageDto language){
        return ResponseEntity.ok(languageService.createLanguage(language));
    }

    @PutMapping()
    public UpdateLanguageDto updateLanguage(@PathVariable Integer id, @RequestBody UpdateLanguageDto language){
        return languageService.updateLanguage(id, language);
    }

    @DeleteMapping("/{id}")
    public void deleteLanguage(@PathVariable Integer id){
        languageService.deleteLanguage(id);
    }
}
