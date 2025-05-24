package com.back.tradetier.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class PurchaseHistoryDto {
    Date date;
    Integer buyer;
    Integer advertisement;
}
