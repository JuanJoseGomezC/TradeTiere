package com.back.tradetier.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.back.tradetier.config.security.SecurityUtils;
import com.back.tradetier.dto.PurchaseHistoryDto;
import com.back.tradetier.dto.PurchaseHistoryIdDto;
import com.back.tradetier.model.Advertisement;
import com.back.tradetier.model.PurchaseHistory;
import com.back.tradetier.model.PurchaseHistoryId;
import com.back.tradetier.model.User;
import com.back.tradetier.repository.AdvertisementRepository;
import com.back.tradetier.repository.PurchaseHistoryRepository;
import com.back.tradetier.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PurchaseHistoryService {

    private final PurchaseHistoryRepository purchaseHistoryRepository;
    private final UserRepository userRepository;
    private final AdvertisementRepository advertisementRepository;
    private final SecurityUtils securityUtils;


    @Transactional(readOnly = true)
    public List<PurchaseHistoryDto> findAllByMail(String mail) {
        if (!securityUtils.getCurrentUser().getMail().equals(mail)) {
            throw new EntityNotFoundException("User not found");
        }

        List<PurchaseHistory> lista =  purchaseHistoryRepository.findPurchaseHistoryByUserMail(mail);


        return purchaseHistoryRepository.findPurchaseHistoryByUserMail(mail)
                .stream()
                .map(this::mapToDTO)
                .toList();
    }


    public PurchaseHistoryDto createPurchaseHistory(PurchaseHistoryDto dto) {
        User buyer = userRepository.findById(dto.getBuyer())
            .orElseThrow(() -> new EntityNotFoundException("User not found"));

        Advertisement advertisement = advertisementRepository.findById(dto.getAdvertisement())
            .orElseThrow(() -> new EntityNotFoundException("Advertisement not found"));

        PurchaseHistoryId id = PurchaseHistoryId.builder()
            .buyer(buyer)
            .advertisement(advertisement)
            .build();

        PurchaseHistory purchaseHistory = PurchaseHistory.builder()
            .id(id)
            .build();

        purchaseHistory = purchaseHistoryRepository.save(purchaseHistory);
        return mapToDTO(purchaseHistory);
    }

    public PurchaseHistoryDto getById(PurchaseHistoryIdDto id) {
        return purchaseHistoryRepository.findById(mapToId(id))
            .map(this::mapToDTO)
            .orElseThrow(() -> new EntityNotFoundException("Purchase history not found"));
    }

    public void deletePurchaseHistory(PurchaseHistoryIdDto id) {
        purchaseHistoryRepository.deleteById(mapToId(id));
    }

    private PurchaseHistoryId mapToId(PurchaseHistoryIdDto dto) {
        User buyer = userRepository.findById(dto.getBuyerId())
            .orElseThrow(() -> new EntityNotFoundException("User not found"));

        Advertisement advertisement = advertisementRepository.findById(dto.getAdvertisementId())
            .orElseThrow(() -> new EntityNotFoundException("Advertisement not found"));

        return PurchaseHistoryId.builder()
            .buyer(buyer)
            .advertisement(advertisement)
            .build();
    }

    private PurchaseHistoryDto mapToDTO(PurchaseHistory purchaseHistory) {
        return PurchaseHistoryDto.builder()
            .buyer(purchaseHistory.getId().getBuyer().getId())
            .date(purchaseHistory.getDate())
            .advertisement(purchaseHistory.getId().getAdvertisement().getId())
            .build();
    }
}
