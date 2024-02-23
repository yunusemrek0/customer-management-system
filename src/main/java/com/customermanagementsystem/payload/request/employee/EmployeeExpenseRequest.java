package com.customermanagementsystem.payload.request.employee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeExpenseRequest {

    @NotNull(message = "Lütfen geçerli bir personel seçiniz.")
    private Long employeeId;

    @NotNull(message = "Tutar ksımı boş bırakılamaz.")
    private Double total;

    private String description;
}
