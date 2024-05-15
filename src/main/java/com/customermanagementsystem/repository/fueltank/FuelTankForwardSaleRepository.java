package com.customermanagementsystem.repository.fueltank;

import com.customermanagementsystem.entity.fueltank.FuelTankForwardSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuelTankForwardSaleRepository extends JpaRepository<FuelTankForwardSale,Long> {
}
