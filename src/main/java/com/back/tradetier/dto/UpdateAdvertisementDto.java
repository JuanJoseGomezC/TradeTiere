package com.back.tradetier.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAdvertisementDto {
    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
    private String title;

    @Size(min = 10, max = 1000, message = "Description must be between 10 and 1000 characters")
    private String description;

    private Integer location;
    private Integer specie;
    private Integer race;
    private LocalDate birthdate;
    private Integer language;
    private String gender;

    @Positive(message = "Price must be positive")
    private Double price;
}
