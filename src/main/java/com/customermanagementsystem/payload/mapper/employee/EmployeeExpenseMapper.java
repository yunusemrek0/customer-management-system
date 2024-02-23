package com.customermanagementsystem.payload.mapper.employee;

import com.customermanagementsystem.entity.employee.EmployeeExpense;
import com.customermanagementsystem.payload.request.employee.EmployeeExpenseRequest;
import com.customermanagementsystem.payload.response.employee.EmployeeExpenseResponse;
import com.customermanagementsystem.service.helper.DateTimeTranslator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeExpenseMapper {

    private final DateTimeTranslator dateTimeTranslator;

    public EmployeeExpense mapEmployeeExpenseRequestToEmployeeExpense(EmployeeExpenseRequest employeeExpenseRequest){

        return EmployeeExpense.builder()
                .description(employeeExpenseRequest.getDescription())
                .total(employeeExpenseRequest.getTotal())
                .dateTime(dateTimeTranslator.parseLocalDateTime())
                .build();
    }

    public EmployeeExpenseResponse mapEmployeeExpenseRequestToEmployeeExpense(EmployeeExpense employeeExpense){

        return EmployeeExpenseResponse.builder()
                .id(employeeExpense.getId())
                .employeeName(employeeExpense.getEmployee().getName())
                .description(employeeExpense.getDescription())
                .total(employeeExpense.getTotal())
                .dateTime(employeeExpense.getDateTime())
                .build();
    }
}
