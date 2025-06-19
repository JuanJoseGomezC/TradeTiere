package com.back.tradetier.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor 
public class LanguageDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    Integer id;
    String language;
}
