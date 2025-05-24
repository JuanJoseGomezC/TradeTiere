package com.back.tradetier.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.back.tradetier.controller.PurchaseHistoryController;
import com.back.tradetier.dto.PurchaseHistoryDto;
import com.back.tradetier.dto.UpdatePurchaseHistoryDto;
import com.back.tradetier.repository.PurchaseHistoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PurchaseHistoryService {

    private final PurchaseHistoryRepository purchaseHistoryRepository;

    public List<PurchaseHistoryDto> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    public PurchaseHistoryDto getById() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    public PurchaseHistoryController createPurchaseHistory(PurchaseHistoryDto purchaseHistory) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createPurchaseHistory'");
    }

    public UpdatePurchaseHistoryDto updatePurchaseHistory(Integer id, UpdatePurchaseHistoryDto purchaseHistory) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatePurchaseHistory'");
    }

    public void createPurchaseHistory(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createPurchaseHistory'");
    }

    public void deletePurchaseHistory(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletePurchaseHistory'");
    }
}
