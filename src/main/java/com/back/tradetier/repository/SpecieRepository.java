package com.back.tradetier.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.tradetier.model.Specie;

@Repository
public interface SpecieRepository extends JpaRepository <Specie, Integer>{

}
