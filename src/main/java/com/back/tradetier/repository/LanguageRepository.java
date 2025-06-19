package com.back.tradetier.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.tradetier.model.Language;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer>{

}
