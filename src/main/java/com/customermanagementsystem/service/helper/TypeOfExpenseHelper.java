package com.customermanagementsystem.service.helper;

import com.customermanagementsystem.entity.expense.Expense;
import com.customermanagementsystem.entity.expense.TypeOfExpense;
import com.customermanagementsystem.exception.ResourceNotFoundException;
import com.customermanagementsystem.payload.messages.ErrorMessages;
import com.customermanagementsystem.repository.expense.TypeOfExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TypeOfExpenseHelper {

    private final TypeOfExpenseRepository typeOfExpenseRepository;

    public TypeOfExpense isExistById(Long id){
        return typeOfExpenseRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException(String.format(ErrorMessages.PRODUCT_NOT_FOUND_ID,id))
        );
    }

    public void expenseBalanceCalculator(TypeOfExpense typeOfExpense,Double total){
        double newBalance = typeOfExpense.getBalance() + total;
        typeOfExpense.setBalance(newBalance);
        typeOfExpenseRepository.save(typeOfExpense);

    }
}
