package com.customermanagementsystem.payload.request.expense;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExpenseRequest {

    private Long typeOfExpenseId;

    private Double total;

    private String description;
}
