package com.back.tradetier.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateLanguageDto {

    @NotBlank(message = "El idioma no puede estar vacío")
    @Size(min = 2, max = 50, message = "El idioma debe tener entre 2 y 50 caracteres")
    String language;
}
