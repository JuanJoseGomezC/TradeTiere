package com.back.tradetier.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.back.tradetier.model.PurchaseHistory;
import com.back.tradetier.model.PurchaseHistoryId;

@Repository
public interface PurchaseHistoryRepository extends JpaRepository<PurchaseHistory, PurchaseHistoryId>{

    @Query("SELECT ph FROM PurchaseHistory ph " +
           "JOIN FETCH ph.id.buyer " +
           "JOIN FETCH ph.id.advertisment " +
           "WHERE ph.id.buyer.mail = :email")
    List<PurchaseHistory> findPurchaseHistoryByUserEmail(@Param("email") String email);
}
