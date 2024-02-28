package com.customermanagementsystem.repository.dailysale.fuelpomp;

import com.customermanagementsystem.entity.dailysale.fuelpomp.FuelPomp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuelPompRepository extends JpaRepository<FuelPomp,Long> {

    List<FuelPomp> getByIsTransferredIsNull();
}
