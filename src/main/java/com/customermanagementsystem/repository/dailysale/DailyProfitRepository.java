package com.customermanagementsystem.repository.dailysale;

import com.customermanagementsystem.entity.dailysale.DailyProfit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface DailyProfitRepository extends JpaRepository<DailyProfit,Long> {

    @Query("SELECT SUM(d.profit) FROM DailyProfit d WHERE d.dateTime > :startDate AND d.dateTime < :endDate")
    Double findTotalExpenseBetweenDate(LocalDateTime startDate, LocalDateTime endDate);
}
