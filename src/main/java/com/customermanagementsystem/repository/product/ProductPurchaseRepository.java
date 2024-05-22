package com.customermanagementsystem.repository.product;

import com.customermanagementsystem.entity.product.ProductPurchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductPurchaseRepository extends JpaRepository<ProductPurchase,Long> {

    List<ProductPurchase> getByProductId(Long productId);
    List<ProductPurchase> getByDealerId(Long dealerId);

    @Query("SELECT p.product.id, p.product.name, SUM(p.amount), SUM(p.total) " +
            "FROM ProductPurchase p " +
            "WHERE p.dateTime > :startDate AND p.dateTime < :endDate " +
            "GROUP BY p.product.id, p.product.name")
    List<Object[]> findPurchaseSummary(LocalDateTime startDate, LocalDateTime endDate);
}
