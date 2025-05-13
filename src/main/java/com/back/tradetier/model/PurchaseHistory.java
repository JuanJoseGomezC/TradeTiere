package com.back.tradetier.model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity(name = "PurchaseHistory")
@Table(name = "\"PurchaseHistory\"", schema = "public")
@Data
@Builder
public class PurchaseHistory {

    @EmbeddedId
    private PurchaseHistoryId id;

    @Builder.Default
    @Column(name = "date", nullable = false)
    private LocalDate date = ZonedDateTime.now(ZoneId.of("Europe/Madrid")).toLocalDate();
}
