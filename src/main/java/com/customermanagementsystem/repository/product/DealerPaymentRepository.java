package com.customermanagementsystem.repository.product;

import com.customermanagementsystem.entity.product.DealerPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealerPaymentRepository extends JpaRepository<DealerPayment,Long> {
}
