package com.back.tradetier.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Embeddable
@Data
@Builder
public class PurchaseHistoryId {

    @ManyToOne
    @JoinColumn(name = "user_buy_id", nullable = false)
    private User buyer;

    @ManyToOne
    @JoinColumn(name = "advertisement_id", nullable = false)
    private Advertisement advertisement;
}
