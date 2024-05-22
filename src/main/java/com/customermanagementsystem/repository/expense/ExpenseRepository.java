package com.customermanagementsystem.repository.expense;

import com.customermanagementsystem.entity.expense.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long> {

    @Query("SELECT SUM(e.total) FROM Expense e WHERE e.dateTime > :startDate AND e.dateTime < :endDate")
    Double findTotalExpenseBetweenDate(LocalDateTime startDate, LocalDateTime endDate);
}
