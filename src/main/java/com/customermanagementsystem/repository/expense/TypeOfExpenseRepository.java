package com.customermanagementsystem.repository.expense;

import com.customermanagementsystem.entity.expense.TypeOfExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeOfExpenseRepository extends JpaRepository<TypeOfExpense,Long> {
}
