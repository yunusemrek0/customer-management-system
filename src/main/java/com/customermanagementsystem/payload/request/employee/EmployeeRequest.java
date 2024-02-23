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
public class EmployeeRequest {

    @NotNull(message = "Personel adı kısmı boş geçilemez.")
    private String name;

    @NotNull(message = "Personel bakiye kısmı boş geçilemez.")
    private Double balance;
}
