package com.back.tradetier.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.tradetier.model.Race;

@Repository
public interface RaceRepository extends JpaRepository<Race, Integer>{

}
