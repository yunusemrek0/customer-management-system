package com.customermanagementsystem.service.helper.dailysale;

import com.customermanagementsystem.entity.dailysale.DailySale;
import com.customermanagementsystem.entity.employee.EmployeeExpense;
import com.customermanagementsystem.repository.employee.EmployeeExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EmployeeExpenseHelperForDailySale {

    private final EmployeeExpenseRepository employeeExpenseRepository;

    public List<EmployeeExpense> getByDailySaleIsNull(){
        return employeeExpenseRepository.getByDailySaleIsNull();
    }

    public double totalEmployeeExpense(List<EmployeeExpense> employeeExpenses){
        double total=0;

        for (EmployeeExpense employeeExpense:employeeExpenses){
            total+= employeeExpense.getTotal();
        }

        return total;
    }

    public void saveDailySaleForEmployeeExpense(List<EmployeeExpense> employeeExpenses, DailySale dailySale){
        for (EmployeeExpense employeeExpense:employeeExpenses){
            employeeExpense.setDailySale(dailySale);
            employeeExpenseRepository.save(employeeExpense);
        }
    }
}
