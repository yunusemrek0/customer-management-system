package com.customermanagementsystem.repository.dailysale;

import com.customermanagementsystem.entity.dailysale.DailyExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface DailyExpenseRepository extends JpaRepository<DailyExpense,Long> {

    List<DailyExpense> getByDailySaleIsNull();

    @Query("SELECT SUM(e.total) FROM DailyExpense e WHERE e.dateTime > :startDate AND e.dateTime < :endDate")
    Double findTotalExpenseBetweenDate(LocalDateTime startDate, LocalDateTime endDate);
}
