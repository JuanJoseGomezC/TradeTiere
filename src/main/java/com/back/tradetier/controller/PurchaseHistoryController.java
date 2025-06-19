package com.back.tradetier.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.tradetier.dto.PurchaseHistoryDto;
import com.back.tradetier.dto.PurchaseHistoryIdDto;
import com.back.tradetier.service.PurchaseHistoryService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@RequestMapping("/api/v1/purchaseHistory")
@RestController
@RequiredArgsConstructor
public class PurchaseHistoryController {

    private final PurchaseHistoryService purchaseHistoryService;

    @GetMapping("/all/{mail}")
    public ResponseEntity<List<PurchaseHistoryDto>> findAllByMail(@PathVariable String mail){
        return  ResponseEntity.ok(purchaseHistoryService.findAllByMail(mail));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseHistoryDto> getById(@PathVariable PurchaseHistoryIdDto id){
        return ResponseEntity.ok(purchaseHistoryService.getById(id));
    }

    @PostMapping()
    public ResponseEntity<PurchaseHistoryDto> createPurchaseHistory(@RequestBody @Valid PurchaseHistoryDto purchaseHistory){
        return ResponseEntity.ok(purchaseHistoryService.createPurchaseHistory(purchaseHistory));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePurchaseHistory(@PathVariable PurchaseHistoryIdDto id){
        purchaseHistoryService.deletePurchaseHistory(id);
        return ResponseEntity.noContent().build();
    }
}
