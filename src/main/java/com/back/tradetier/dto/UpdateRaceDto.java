package com.back.tradetier.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateRaceDto {
    String name;
    Integer specie;
    Integer language;
}
