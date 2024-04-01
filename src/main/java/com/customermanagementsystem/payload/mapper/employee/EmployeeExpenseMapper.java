package com.customermanagementsystem.payload.mapper.employee;

import com.customermanagementsystem.entity.employee.EmployeeExpense;
import com.customermanagementsystem.payload.request.employee.EmployeeExpenseRequest;
import com.customermanagementsystem.payload.response.employee.EmployeeExpenseResponse;
import com.customermanagementsystem.service.helper.DateTimeTranslator;
import com.customermanagementsystem.service.helper.MapperHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeExpenseMapper {

    private final DateTimeTranslator dateTimeTranslator;
    private final MapperHelper mapperHelper;

    public EmployeeExpense mapEmployeeExpenseToEmployeeExpenseResponse(EmployeeExpenseRequest employeeExpenseRequest){

        return EmployeeExpense.builder()
                .description(employeeExpenseRequest.getDescription())
                .total(mapperHelper.formatDoubleValue(employeeExpenseRequest.getTotal()))
                .dateTime(dateTimeTranslator.parseLocalDateTime())
                .build();
    }

    public EmployeeExpenseResponse mapEmployeeExpenseToEmployeeExpenseResponse(EmployeeExpense employeeExpense){

        return EmployeeExpenseResponse.builder()
                .id(employeeExpense.getId())
                .employeeName(employeeExpense.getEmployee().getName())
                .description(employeeExpense.getDescription())
                .total(mapperHelper.formatDoubleValue(employeeExpense.getTotal()))
                .dateTime(employeeExpense.getDateTime())
                .build();
    }
}
