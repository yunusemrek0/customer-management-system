package com.customermanagementsystem.payload.mapper.expense;

import com.customermanagementsystem.entity.expense.TypeOfExpense;
import com.customermanagementsystem.payload.request.expense.TypeOfExpenseRequest;
import com.customermanagementsystem.payload.response.expense.TypeOfExpenseResponse;
import com.customermanagementsystem.service.helper.MapperHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TypeOfExpenseMapper {

    private final MapperHelper mapperHelper;

    public TypeOfExpense mapRequestToTypeOfExpense(TypeOfExpenseRequest typeOfExpenseRequest){
        return TypeOfExpense.builder()
                .name(typeOfExpenseRequest.getName())
                .balance(mapperHelper.formatDoubleValue(typeOfExpenseRequest.getBalance()))
                .build();
    }

    public TypeOfExpenseResponse mapTypeOfExpenseToResponse(TypeOfExpense typeOfExpense){
        return TypeOfExpenseResponse.builder()
                .id(typeOfExpense.getId())
                .balance(typeOfExpense.getBalance())
                .name(typeOfExpense.getName())
                .build();
    }
}
