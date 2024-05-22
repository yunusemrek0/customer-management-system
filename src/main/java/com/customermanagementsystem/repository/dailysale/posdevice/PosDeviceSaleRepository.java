package com.customermanagementsystem.repository.dailysale.posdevice;

import com.customermanagementsystem.entity.dailysale.posdevice.PosDeviceSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PosDeviceSaleRepository extends JpaRepository<PosDeviceSale,Long> {

    List<PosDeviceSale> findByDateTimeBetween(LocalDateTime startDateTime, LocalDateTime endDateTime);

    List<PosDeviceSale> getByDailySaleIsNull();

    @Query("SELECT p.posDevice.id, p.posDevice.name, SUM(p.total) " +
            "FROM PosDeviceSale p " +
            "WHERE p.dateTime > :startDate AND p.dateTime < :endDate " +
            "GROUP BY p.posDevice.id, p.posDevice.name")
    List<Object[]> findPosDeviceSalesBetweenDate(LocalDateTime startDate, LocalDateTime endDate);
}
