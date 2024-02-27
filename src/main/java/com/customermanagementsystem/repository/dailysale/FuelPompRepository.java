package com.customermanagementsystem.repository.dailysale;

import com.customermanagementsystem.entity.dailysale.fuelpomp.FuelPomp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuelPompRepository extends JpaRepository<FuelPomp,Long> {
}
