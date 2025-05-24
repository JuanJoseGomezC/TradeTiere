package com.back.tradetier.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.back.tradetier.dto.LanguageDto;
import com.back.tradetier.dto.UpdateLanguageDto;
import com.back.tradetier.repository.LanguageRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LanguageService {
    private final LanguageRepository languageRepository;

    public List<LanguageDto> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    public LanguageDto getById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    public LanguageDto createLanguage(LanguageDto language) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createLanguage'");
    }

    public UpdateLanguageDto updateLanguage(Integer id, UpdateLanguageDto language) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateLanguage'");
    }

    public void deleteLanguage(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteLanguage'");
    }

}
