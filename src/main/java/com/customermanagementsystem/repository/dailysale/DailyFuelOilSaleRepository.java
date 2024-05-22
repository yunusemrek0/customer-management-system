package com.customermanagementsystem.repository.dailysale;

import com.customermanagementsystem.entity.dailysale.DailyFuelOilSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface DailyFuelOilSaleRepository extends JpaRepository<DailyFuelOilSale,Long> {

    List<DailyFuelOilSale> getByDailySaleIsNull();

    @Query("SELECT f.product.id, f.product.name, SUM(f.amount), SUM(f.total) " +
            "FROM DailyFuelOilSale f " +
            "WHERE f.dateTime > :startDate AND f.dateTime < :endDate " +
            "GROUP BY f.product.id, f.product.name")
    List<Object[]> findSalesSummary(LocalDateTime startDate, LocalDateTime endDate);
}
