package com.customermanagementsystem.repository.dailysale.fuelpomp;

import com.customermanagementsystem.entity.dailysale.fuelpomp.FuelPompStatistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuelPompStatisticRepository extends JpaRepository<FuelPompStatistic,Long> {

    List<FuelPompStatistic> getByDailySaleIsNull();
}
