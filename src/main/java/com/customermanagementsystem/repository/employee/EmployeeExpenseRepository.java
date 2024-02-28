package com.customermanagementsystem.repository.employee;

import com.customermanagementsystem.entity.employee.EmployeeExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeExpenseRepository extends JpaRepository<EmployeeExpense,Long> {

    List<EmployeeExpense> getByEmployeeId(Long employeeId);

    List<EmployeeExpense> getByDailySaleIsNull();
}
