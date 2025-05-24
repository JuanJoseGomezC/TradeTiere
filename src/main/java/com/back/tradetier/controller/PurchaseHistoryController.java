package com.back.tradetier.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.tradetier.dto.PurchaseHistoryDto;
import com.back.tradetier.dto.UpdatePurchaseHistoryDto;
import com.back.tradetier.service.PurchaseHistoryService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@RequestMapping("/api/v1/purchaseHistory")
@RestController
@RequiredArgsConstructor
public class PurchaseHistoryController {

    private final PurchaseHistoryService purchaseHistoryService;

    @GetMapping()
    public List<PurchaseHistoryDto> getAll(){
        return purchaseHistoryService.getAll();
    }

    @GetMapping("/{id}")
    public PurchaseHistoryDto getById(@PathVariable Integer id){
        return purchaseHistoryService.getById();
    }

    @PostMapping()
    public PurchaseHistoryController createPurchaseHistory(@RequestBody @Valid PurchaseHistoryDto purchaseHistory){
        return purchaseHistoryService.createPurchaseHistory(purchaseHistory);
    }

    @PutMapping()
    public UpdatePurchaseHistoryDto updatePurchaseHistory(@PathVariable Integer id, @RequestBody UpdatePurchaseHistoryDto purchaseHistory){
        return purchaseHistoryService.updatePurchaseHistory(id, purchaseHistory);
    }

    @DeleteMapping("/{id}")
    public void deletePurchaseHistory(@PathVariable Integer id){
        purchaseHistoryService.deletePurchaseHistory(id);
    }
}
