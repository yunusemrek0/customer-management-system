package com.customermanagementsystem.payload.mapper.employee;

import com.customermanagementsystem.entity.employee.Employee;
import com.customermanagementsystem.payload.request.employee.EmployeeRequest;
import com.customermanagementsystem.payload.response.employee.EmployeeResponse;
import com.customermanagementsystem.service.helper.MapperHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeMapper {

    private final MapperHelper mapperHelper;

    public Employee mapEmloyeeRequestToEmployee(EmployeeRequest employeeRequest){

        return Employee.builder()
                .name(employeeRequest.getName())
                //.balance(mapperHelper.formatDoubleValue(employeeRequest.getBalance()))
                .build();
    }

    public EmployeeResponse mapEmloyeeToEmployeeResponse(Employee employee){

        return EmployeeResponse.builder()
                .id(employee.getId())
                .name(employee.getName())
                .balance(mapperHelper.formatDoubleValue(employee.getBalance()))
                .build();
    }
}
