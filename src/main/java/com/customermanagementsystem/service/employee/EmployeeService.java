package com.customermanagementsystem.service.employee;

import com.customermanagementsystem.payload.mapper.employee.EmployeeMapper;
import com.customermanagementsystem.payload.messages.SuccessMessages;
import com.customermanagementsystem.payload.request.employee.EmployeeRequest;
import com.customermanagementsystem.payload.response.employee.EmployeeResponse;
import com.customermanagementsystem.repository.employee.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public String saveEmployee(EmployeeRequest employeeRequest) {

        employeeRepository.save(
                employeeMapper.mapEmloyeeRequestToEmployee(employeeRequest)
        );

        return SuccessMessages.EMPLOYEE_SAVE;


    }

    public List<EmployeeResponse> getAll() {

        return employeeRepository.findAll()
                .stream()
                .map(employeeMapper::mapEmloyeeToEmployeeResponse)
                .collect(Collectors.toList());
    }


}
