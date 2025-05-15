package com.back.tradetier.model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity(name = "User")
@Table(name = "\"User\"", schema = "public")
@Data
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "mail", nullable = false, unique = true)
    private String mail;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "birthdate", nullable = false)
    private LocalDate birthdate;

    @Column(name = "password", nullable = false)
    private String password;

    @Builder.Default
    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt = ZonedDateTime.now(ZoneId.of("Europe/Madrid")).toLocalDate();

}
