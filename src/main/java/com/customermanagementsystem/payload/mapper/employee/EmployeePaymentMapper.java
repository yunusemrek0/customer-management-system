package com.customermanagementsystem.payload.mapper.employee;

import com.customermanagementsystem.entity.employee.EmployeePayment;
import com.customermanagementsystem.payload.request.employee.EmployeePaymentRequest;
import com.customermanagementsystem.payload.response.employee.EmployeePaymentResponse;
import com.customermanagementsystem.service.helper.DateTimeTranslator;
import com.customermanagementsystem.service.helper.MapperHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeePaymentMapper {

    private final DateTimeTranslator dateTimeTranslator;
    private final MapperHelper mapperHelper;

    public EmployeePayment mapEmployeePaymentRequestToEmployeePayment(EmployeePaymentRequest employeePaymentRequest){

        return EmployeePayment.builder()
                .total(mapperHelper.formatDoubleValue(employeePaymentRequest.getTotal()))
                .dateTime(dateTimeTranslator.parseLocalDateTime())
                .build();
    }

    public EmployeePaymentResponse mapEmployeePaymentToEmployeePaymentResponse(EmployeePayment employeePayment){

        return EmployeePaymentResponse.builder()
                .id(employeePayment.getId())
                .employeeName(employeePayment.getEmployee().getName())
                .dateTime(employeePayment.getDateTime())
                .total(employeePayment.getTotal())
                .type("ÖDEME")
                .build();

    }
}
