package com.back.tradetier.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Race")
@Table(name = "\"Race\"", schema = "public")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;


    @ManyToOne
    @JoinColumn(name = "language_id", nullable = false)
    private Language language;

    @ManyToOne
    @JoinColumn(name = "specie_id", nullable = false)
    private Specie specie;
}
