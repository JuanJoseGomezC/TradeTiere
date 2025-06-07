package com.back.tradetier.dto;

import java.sql.Date;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class AdvertisementDto {
    String title;
    String description;
    Integer location;
    Integer language;
    Date birthdate;
    String gender;
    Float price;
    Integer race;
    Integer specie;
    Boolean state;
    LocalDate create_at;
    ImageDto image;
}
