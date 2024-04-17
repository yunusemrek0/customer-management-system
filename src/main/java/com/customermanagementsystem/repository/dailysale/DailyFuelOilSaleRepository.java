package com.customermanagementsystem.repository.dailysale;

import com.customermanagementsystem.entity.dailysale.DailyFuelOilSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DailyFuelOilSaleRepository extends JpaRepository<DailyFuelOilSale,Long> {

    List<DailyFuelOilSale> getByDailySaleIsNull();
}
