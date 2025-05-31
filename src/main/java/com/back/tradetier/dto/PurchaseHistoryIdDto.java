package com.back.tradetier.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PurchaseHistoryIdDto {

    private Integer buyerId;
    private Integer advertisementId;
}
