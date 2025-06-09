package com.back.tradetier.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseHistoryId {

    @ManyToOne
    @JoinColumn(name = "user_buy_id", nullable = false)
    private User buyer;

    @ManyToOne
    @JoinColumn(name = "advertisment_id", nullable = false)
    private Advertisment advertisment;
}
