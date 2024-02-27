package com.customermanagementsystem.repository.dailysale;

import com.customermanagementsystem.entity.dailysale.DailySale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailySaleRepository extends JpaRepository<DailySale,Long> {
}
