package com.customermanagementsystem.repository.employee;

import com.customermanagementsystem.entity.employee.EmployeePayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeePaymentRepository extends JpaRepository<EmployeePayment,Long> {

    List<EmployeePayment> getByDailySaleIsNull();
}
