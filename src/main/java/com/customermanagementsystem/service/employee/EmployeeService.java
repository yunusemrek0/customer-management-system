package com.customermanagementsystem.service.employee;

import com.customermanagementsystem.entity.employee.Employee;
import com.customermanagementsystem.payload.mapper.employee.EmployeeExpenseMapper;
import com.customermanagementsystem.payload.mapper.employee.EmployeeMapper;
import com.customermanagementsystem.payload.mapper.employee.EmployeePaymentMapper;
import com.customermanagementsystem.payload.messages.SuccessMessages;
import com.customermanagementsystem.payload.request.employee.EmployeeRequest;
import com.customermanagementsystem.payload.response.employee.EmployeeResponse;
import com.customermanagementsystem.payload.response.employee.abstraction.AbstractEmployeeMovementResponse;
import com.customermanagementsystem.repository.employee.EmployeeExpenseRepository;
import com.customermanagementsystem.repository.employee.EmployeePaymentRepository;
import com.customermanagementsystem.repository.employee.EmployeeRepository;
import com.customermanagementsystem.service.helper.EmployeeHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final EmployeeHelper employeeHelper;
    private final EmployeePaymentRepository employeePaymentRepository;
    private final EmployeeExpenseRepository employeeExpenseRepository;
    private final EmployeeExpenseMapper employeeExpenseMapper;
    private final EmployeePaymentMapper employeePaymentMapper;

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


    public String updateEmployee(EmployeeRequest employeeRequest, Long id) {

        Employee employee = employeeHelper.isExistById(id);
        Employee employeeToUpdate = employeeMapper.mapEmloyeeRequestToEmployee(employeeRequest);
        employeeToUpdate.setBalance(employee.getBalance());
        employeeToUpdate.setId(id);

        employeeRepository.save(employeeToUpdate);
        return null;
    }

    public EmployeeResponse getById(Long id) {

        Optional<Employee> employee = employeeRepository.findById(id);

        return employeeMapper.mapEmloyeeToEmployeeResponse(employee.get());
    }


    public List<AbstractEmployeeMovementResponse> getDetails(Long id) {

        List<AbstractEmployeeMovementResponse> list = new ArrayList<>();

        list.addAll(
                employeeExpenseRepository.getByEmployeeId(id)
                        .stream()
                        .map(employeeExpenseMapper::mapEmployeeExpenseToEmployeeExpenseResponse)
                        .toList()
        );

        list.addAll(
                employeePaymentRepository.getByEmployeeId(id)
                        .stream()
                        .map(employeePaymentMapper::mapEmployeePaymentToEmployeePaymentResponse)
                        .toList()
        );

        list.sort(Comparator.comparing(AbstractEmployeeMovementResponse::getDateTime).reversed());


        return list;
    }
}
