package com.customermanagementsystem.service.helper;


import com.customermanagementsystem.entity.employee.Employee;
import com.customermanagementsystem.entity.employee.EmployeeExpense;
import com.customermanagementsystem.exception.ResourceNotFoundException;
import com.customermanagementsystem.payload.messages.ErrorMessages;
import com.customermanagementsystem.repository.employee.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EmployeeHelper {

    private final EmployeeRepository employeeRepository;


    public Employee isExistById(Long customerId){

        return employeeRepository.findById(customerId).orElseThrow(
                ()-> new ResourceNotFoundException(String.format(ErrorMessages.EMPLOYEE_NOT_FOUND_ID,customerId))
        );
    }

    public void employeeBalanceCalculator(Employee employee,Double total){
        double newBalance = employee.getBalance()+total;
        employee.setBalance(newBalance);
        employeeRepository.save(employee);
    }

    public void employeeBalanceCalculatorForPayment(Employee employee,Double total){
        double newBalance = employee.getBalance()-total;
        employee.setBalance(newBalance);
        employeeRepository.save(employee);
    }



}
