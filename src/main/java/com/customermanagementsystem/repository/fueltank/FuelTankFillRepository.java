package com.customermanagementsystem.repository.fueltank;

import com.customermanagementsystem.entity.fueltank.FuelTankFill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuelTankFillRepository extends JpaRepository<FuelTankFill,Long> {

    List<FuelTankFill> getByDailySaleIsNull();
}
