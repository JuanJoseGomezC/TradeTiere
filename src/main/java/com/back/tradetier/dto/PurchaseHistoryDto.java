package com.back.tradetier.dto;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PurchaseHistoryDto {
    Integer buyer;
    LocalDate date;
    Integer advertisment;
}
