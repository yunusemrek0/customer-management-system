package com.customermanagementsystem.payload.request.employee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeePaymentRequest {

    private Long employeeId;

    private Double total;
}
