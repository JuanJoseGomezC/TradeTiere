package com.back.tradetier.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class ImageDto {
        private String imageBase64;
        private String name;
        private String contentType;
}
