package com.back.tradetier.dto;

import java.sql.Date;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class AdvertismentDto {
    Integer id;
    String title;
    String description;
    LocationDto location;
    Integer language;
    Date birthdate;
    String gender;
    Float price;
    RaceDto race;
    SpecieDto specie;
    Boolean state;
    LocalDate create_at;
    ImageDto image;
    Integer userId;
}
