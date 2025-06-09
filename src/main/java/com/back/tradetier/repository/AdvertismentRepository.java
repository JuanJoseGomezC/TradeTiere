package com.back.tradetier.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.back.tradetier.model.Advertisment;

@Repository
public interface AdvertismentRepository extends JpaRepository<Advertisment, Integer>{

    /**
     * Encuentra todos los anuncios de un usuario por su email
     * @param mail el email del usuario
     * @return lista de anuncios
     */
    @Query("SELECT a FROM Advertisment a WHERE a.user.mail = :mail")
    List<Advertisment> findAllByUserMail(@Param("mail") String mail);
}
