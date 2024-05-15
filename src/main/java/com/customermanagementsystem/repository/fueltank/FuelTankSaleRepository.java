package com.customermanagementsystem.repository.fueltank;

import com.customermanagementsystem.entity.fueltank.FuelTankSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuelTankSaleRepository extends JpaRepository<FuelTankSale,Long> {

    List<FuelTankSale> getByDailySaleIsNull();
}
