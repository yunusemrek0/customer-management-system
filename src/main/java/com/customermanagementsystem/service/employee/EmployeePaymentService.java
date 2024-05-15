package com.customermanagementsystem.service.employee;

import com.customermanagementsystem.entity.employee.Employee;
import com.customermanagementsystem.entity.employee.EmployeePayment;
import com.customermanagementsystem.payload.mapper.employee.EmployeePaymentMapper;
import com.customermanagementsystem.payload.request.employee.EmployeePaymentRequest;
import com.customermanagementsystem.payload.response.employee.EmployeePaymentResponse;
import com.customermanagementsystem.repository.employee.EmployeePaymentRepository;
import com.customermanagementsystem.service.helper.EmployeeHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeePaymentService {

    private final EmployeePaymentRepository employeePaymentRepository;
    private final EmployeePaymentMapper employeePaymentMapper;
    private final EmployeeHelper employeeHelper;

    @Transactional
    public String saveEmployeePayment(EmployeePaymentRequest employeePaymentRequest) {

        Employee employee = employeeHelper.isExistById(employeePaymentRequest.getEmployeeId());
        EmployeePayment employeePaymentToSave = employeePaymentMapper.mapEmployeePaymentRequestToEmployeePayment(employeePaymentRequest);
        employeePaymentToSave.setEmployee(employee);

        employeeHelper.employeeBalanceCalculatorForPayment(employee,employeePaymentRequest.getTotal());
        employeePaymentRepository.save(employeePaymentToSave);

        return null;

    }

    public List<EmployeePaymentResponse> getAll() {
        return employeePaymentRepository.findAll()
                .stream()
                .map(employeePaymentMapper::mapEmployeePaymentToEmployeePaymentResponse)
                .collect(Collectors.toList());
    }
}
