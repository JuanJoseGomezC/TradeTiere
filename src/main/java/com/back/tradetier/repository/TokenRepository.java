package com.back.tradetier.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.tradetier.model.Token;



@Repository
public interface TokenRepository extends JpaRepository<Token, Integer>{

}
