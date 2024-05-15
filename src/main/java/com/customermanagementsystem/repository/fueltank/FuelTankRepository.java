package com.customermanagementsystem.repository.fueltank;

import com.customermanagementsystem.entity.fueltank.FuelTank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuelTankRepository extends JpaRepository<FuelTank,Long> {
}
