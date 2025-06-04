package com.back.tradetier.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.back.tradetier.config.security.SecurityUtils;
import com.back.tradetier.dto.PurchaseHistoryDto;
import com.back.tradetier.dto.PurchaseHistoryIdDto;
import com.back.tradetier.exceptions.PurchaseHistoryNotFoundException;
import com.back.tradetier.exceptions.ResourceNotFoundException;
import com.back.tradetier.exceptions.UnauthorizedAccessException;
import com.back.tradetier.model.Advertisement;
import com.back.tradetier.model.PurchaseHistory;
import com.back.tradetier.model.PurchaseHistoryId;
import com.back.tradetier.model.User;
import com.back.tradetier.repository.AdvertisementRepository;
import com.back.tradetier.repository.PurchaseHistoryRepository;
import com.back.tradetier.repository.UserRepository;

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
            throw new UnauthorizedAccessException("Solo puedes ver tu propio historial de compras");
        }

        return purchaseHistoryRepository.findPurchaseHistoryByUserEmail(mail)
                .stream()
                .map(this::mapToDTO)
                .toList();
    }


    public PurchaseHistoryDto createPurchaseHistory(PurchaseHistoryDto dto) {
        User buyer = userRepository.findById(dto.getBuyer())
            .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con ID: " + dto.getBuyer()));

        Advertisement advertisement = advertisementRepository.findById(dto.getAdvertisement())
            .orElseThrow(() -> new ResourceNotFoundException("Anuncio no encontrado con ID: " + dto.getAdvertisement()));

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
            .orElseThrow(() -> new PurchaseHistoryNotFoundException("Historial de compra no encontrado"));
    }

    public void deletePurchaseHistory(PurchaseHistoryIdDto id) {
        if (!purchaseHistoryRepository.existsById(mapToId(id))) {
            throw new PurchaseHistoryNotFoundException("Historial de compra no encontrado");
        }
        purchaseHistoryRepository.deleteById(mapToId(id));
    }

    private PurchaseHistoryId mapToId(PurchaseHistoryIdDto dto) {
        User buyer = userRepository.findById(dto.getBuyerId())
            .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con ID: " + dto.getBuyerId()));

        Advertisement advertisement = advertisementRepository.findById(dto.getAdvertisementId())
            .orElseThrow(() -> new ResourceNotFoundException("Anuncio no encontrado con ID: " + dto.getAdvertisementId()));

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
