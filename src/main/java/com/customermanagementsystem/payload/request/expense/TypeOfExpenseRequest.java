package com.customermanagementsystem.payload.request.expense;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TypeOfExpenseRequest {

    private String name;

    private Double balance;
}
