package com.back.tradetier.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.tradetier.model.PurchaseHistory;
import com.back.tradetier.model.PurchaseHistoryId;

@Repository
public interface PurchaseHistoryRepository extends JpaRepository<PurchaseHistory, PurchaseHistoryId>{

}
