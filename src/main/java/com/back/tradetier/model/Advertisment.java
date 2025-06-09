package com.back.tradetier.model;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


// @Data es lo mismo que @Setters, @Getters, @ToString, @EqualsAndHashCode, @RequiredArgsConstructor
// @Builder utiliza el patron de diseño builder, creando una clase interna build a la que le das los atributos a la hora de hacer el constructor
@Entity(name = "Advertisment")
@Table(name = "\"Advertisment\"", schema = "public")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Advertisment {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;    @ManyToOne
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

    @Builder.Default
    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt = ZonedDateTime.now(ZoneId.of("Europe/Madrid")).toLocalDate();

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    private Image image;

}
