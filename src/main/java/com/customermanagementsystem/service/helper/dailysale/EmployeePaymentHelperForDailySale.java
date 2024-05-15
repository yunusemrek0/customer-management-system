package com.customermanagementsystem.service.helper.dailysale;

import com.customermanagementsystem.entity.dailysale.DailySale;
import com.customermanagementsystem.entity.employee.EmployeePayment;
import com.customermanagementsystem.repository.employee.EmployeePaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EmployeePaymentHelperForDailySale {

    private final EmployeePaymentRepository employeePaymentRepository;


    public List<EmployeePayment> getByDailySaleIsNull() {
        return employeePaymentRepository.getByDailySaleIsNull();
    }

    public double totalEmployeePayment(List<EmployeePayment> employeePayments) {
        double total = 0;

        for (EmployeePayment employeePayment:employeePayments){
            total+= employeePayment.getTotal();
        }

        return total;
    }

    public void saveDailySaleForEmployeePayment(List<EmployeePayment> employeePayments, DailySale savedDailySale) {

        for (EmployeePayment employeePayment:employeePayments){
            employeePayment.setDailySale(savedDailySale);
            employeePaymentRepository.save(employeePayment);
        }
    }
}
