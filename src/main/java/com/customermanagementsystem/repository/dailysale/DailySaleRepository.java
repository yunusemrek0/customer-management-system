package com.customermanagementsystem.repository.dailysale;

import com.customermanagementsystem.entity.dailysale.DailySale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface DailySaleRepository extends JpaRepository<DailySale,Long> {

    @Query("SELECT SUM(d.reportZ) FROM DailySale d WHERE d.dateTime > :startDate AND d.dateTime < :endDate")
    Double findTotalReportZBetweenDate(LocalDateTime startDate,LocalDateTime endDate);
}
