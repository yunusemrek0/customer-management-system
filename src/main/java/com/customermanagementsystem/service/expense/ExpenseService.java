package com.customermanagementsystem.service.expense;

import com.customermanagementsystem.entity.expense.Expense;
import com.customermanagementsystem.entity.expense.TypeOfExpense;
import com.customermanagementsystem.payload.mapper.expense.ExpenseMapper;
import com.customermanagementsystem.payload.request.expense.ExpenseRequest;
import com.customermanagementsystem.payload.response.expense.ExpenseResponse;
import com.customermanagementsystem.repository.expense.ExpenseRepository;
import com.customermanagementsystem.service.helper.TypeOfExpenseHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final ExpenseMapper expenseMapper;
    private final TypeOfExpenseHelper typeOfExpenseHelper;

    @Transactional
    public String saveExpense(ExpenseRequest expenseRequest) {
        TypeOfExpense typeOfExpense = typeOfExpenseHelper.isExistById(expenseRequest.getTypeOfExpenseId());
        Expense expenseToSave = expenseMapper.mapRequestToExpense(expenseRequest);
        expenseToSave.setTypeOfExpense(typeOfExpense);

        typeOfExpenseHelper.expenseBalanceCalculator(typeOfExpense,expenseRequest.getTotal());

        expenseRepository.save(expenseToSave);

        return null;
    }

    public List<ExpenseResponse> getAll() {
        return expenseRepository.findAll()
                .stream()
                .map(expenseMapper::mapExpenseToResponse)
                .collect(Collectors.toList());
    }
}
