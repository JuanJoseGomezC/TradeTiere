package com.back.tradetier.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateSpecieDto {
    String name;
    Integer language;
}
