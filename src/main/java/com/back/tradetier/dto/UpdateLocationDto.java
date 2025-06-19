package com.back.tradetier.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateLocationDto {
    String name;
    Integer language;
}
