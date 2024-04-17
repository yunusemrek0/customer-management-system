package com.customermanagementsystem.repository.dailysale;

import com.customermanagementsystem.entity.dailysale.DailyProfit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyProfitRepository extends JpaRepository<DailyProfit,Long> {
}
