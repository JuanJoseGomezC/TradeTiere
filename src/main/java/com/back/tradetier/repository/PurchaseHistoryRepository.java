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

@Query(value = """
    SELECT ph.*
    FROM "PurchaseHistory" ph
    JOIN "User" u ON ph.user_buy_id = u.id
    WHERE u.mail = :mail
    """, nativeQuery = true)
List<PurchaseHistory> findPurchaseHistoryByUserMail(@Param("mail") String mail);


}
