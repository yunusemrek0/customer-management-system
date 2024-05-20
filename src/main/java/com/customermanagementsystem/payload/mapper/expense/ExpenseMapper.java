package com.customermanagementsystem.payload.mapper.expense;

import com.customermanagementsystem.entity.expense.Expense;
import com.customermanagementsystem.payload.request.expense.ExpenseRequest;
import com.customermanagementsystem.payload.response.expense.ExpenseResponse;
import com.customermanagementsystem.service.helper.DateTimeTranslator;
import com.customermanagementsystem.service.helper.MapperHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExpenseMapper {

    private final MapperHelper mapperHelper;
    private final DateTimeTranslator dateTimeTranslator;

    public Expense mapRequestToExpense(ExpenseRequest expenseRequest){
        return Expense.builder()
                .total(mapperHelper.formatDoubleValue(expenseRequest.getTotal()))
                .dateTime(dateTimeTranslator.parseLocalDateTime())
                .description(expenseRequest.getDescription())
                .build();
    }

    public ExpenseResponse mapExpenseToResponse(Expense expense){
        return ExpenseResponse.builder()
                .total(expense.getTotal())
                .typeOfExpenseName(expense.getTypeOfExpense().getName())
                .dateTime(expense.getDateTime())
                .id(expense.getId())
                .description(expense.getDescription())
                .build();
    }
}
