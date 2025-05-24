package com.back.tradetier.model;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;


// @Data es lo mismo que @Setters, @Getters, @ToString, @EqualsAndHashCode, @RequiredArgsConstructor
// @Builder utiliza el patron de diseño builder, creando una clase interna build a la que le das los atributos a la hora de hacer el constructor
@Entity(name = "Advertisement")
@Table(name = "\"Advertisement\"", schema = "public")
@Data
@Builder
public class Advertisement {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "location", nullable = false)
    private Location location;

    @ManyToOne
    @JoinColumn(name = "specie_id", nullable = false)
    private Specie specie;

    @ManyToOne
    @JoinColumn(name = "race_id", nullable = false)
    private Race race;

    @Column(name = "birthdate", nullable = false)
    private Date birthdate;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "price", nullable = false)
    private Float price;

    @ManyToOne
    @JoinColumn(name = "language_id", nullable = false)
    private Language language;

    @Column(name = "state", nullable = false)
    private Boolean state;

    @Column(name = "create_at", nullable = false, columnDefinition = "date DEFAULT 'now()'")
    @Builder.Default
    private LocalDate create_at = ZonedDateTime.now(ZoneId.of("Europe/Spain")).toLocalDate();

}
