package com.customermanagementsystem.service.employee;

import com.customermanagementsystem.entity.employee.Employee;
import com.customermanagementsystem.entity.employee.EmployeeExpense;
import com.customermanagementsystem.payload.mapper.employee.EmployeeExpenseMapper;
import com.customermanagementsystem.payload.messages.SuccessMessages;
import com.customermanagementsystem.payload.request.employee.EmployeeExpenseRequest;
import com.customermanagementsystem.payload.response.employee.EmployeeExpenseResponse;
import com.customermanagementsystem.repository.employee.EmployeeExpenseRepository;
import com.customermanagementsystem.service.helper.EmployeeHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeExpenseService {

    private final EmployeeExpenseRepository employeeExpenseRepository;
    private final EmployeeHelper employeeHelper;
    private final EmployeeExpenseMapper employeeExpenseMapper;


    @Transactional
    public String saveEmployee(EmployeeExpenseRequest employeeExpenseRequest) {

        Employee employee = employeeHelper.isExistById(employeeExpenseRequest.getEmployeeId());

        EmployeeExpense employeeExpenseToSave = employeeExpenseMapper.mapEmployeeExpenseToEmployeeExpenseResponse(employeeExpenseRequest);
        employeeExpenseToSave.setEmployee(employee);

        employeeHelper.employeeBalanceCalculator(employee,employeeExpenseToSave.getTotal());

        employeeExpenseRepository.save(employeeExpenseToSave);

        return SuccessMessages.EMPLOYEE_EXPENSE_SAVE;


    }


    public List<EmployeeExpenseResponse> getByEmployee(Long employeeId) {

        employeeHelper.isExistById(employeeId);

        return employeeExpenseRepository.getByEmployeeId(employeeId)
                .stream()
                .map(employeeExpenseMapper::mapEmployeeExpenseToEmployeeExpenseResponse)
                .collect(Collectors.toList());



    }

    public List<EmployeeExpenseResponse> getAll() {
        return employeeExpenseRepository.getByDailySaleIsNull()
                .stream()
                .map(employeeExpenseMapper::mapEmployeeExpenseToEmployeeExpenseResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public String deleteById(Long id) {
        EmployeeExpense employeeExpenseToDelete = employeeExpenseRepository.findById(id).get();
        Employee employee = employeeHelper.isExistById(employeeExpenseToDelete.getEmployee().getId());
        employeeHelper.employeeBalanceCalculatorForPayment(employee,employeeExpenseToDelete.getTotal());
        employeeExpenseRepository.deleteById(id);
        return null;
    }
}
