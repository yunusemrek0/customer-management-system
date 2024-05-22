package com.customermanagementsystem.repository.dailysale;

import com.customermanagementsystem.entity.dailysale.CashDelivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CashDeliveryRepository extends JpaRepository<CashDelivery,Long> {

    List<CashDelivery> getByDailySaleIsNull();
}
