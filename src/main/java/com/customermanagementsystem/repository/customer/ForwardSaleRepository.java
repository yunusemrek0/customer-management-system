package com.customermanagementsystem.repository.customer;

import com.customermanagementsystem.entity.customer.ForwardSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForwardSaleRepository extends JpaRepository<ForwardSale,Long> {
}
