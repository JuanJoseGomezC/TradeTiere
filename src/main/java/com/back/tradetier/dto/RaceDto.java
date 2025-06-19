package com.back.tradetier.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RaceDto {
    Integer id;
    String name;
    Integer specie;
    Integer language;
}
