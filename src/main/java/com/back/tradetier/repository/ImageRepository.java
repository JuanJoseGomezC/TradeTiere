package com.back.tradetier.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.tradetier.model.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {

}
