package com.customermanagementsystem.service.expense;

import com.customermanagementsystem.entity.expense.TypeOfExpense;
import com.customermanagementsystem.payload.mapper.expense.TypeOfExpenseMapper;
import com.customermanagementsystem.payload.request.expense.TypeOfExpenseRequest;
import com.customermanagementsystem.payload.response.expense.TypeOfExpenseResponse;
import com.customermanagementsystem.repository.expense.TypeOfExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TypeOfExpenseService {

    private final TypeOfExpenseRepository typeOfExpenseRepository;
    private final TypeOfExpenseMapper typeOfExpenseMapper;


    public String saveTypeOfExpense(TypeOfExpenseRequest typeOfExpenseRequest) {
        TypeOfExpense typeOfExpenseToSave = typeOfExpenseMapper.mapRequestToTypeOfExpense(typeOfExpenseRequest);
        typeOfExpenseRepository.save(typeOfExpenseToSave);

        return null;
    }

    public List<TypeOfExpenseResponse> getAll() {

        return typeOfExpenseRepository.findAll()
                .stream()
                .map(typeOfExpenseMapper::mapTypeOfExpenseToResponse)
                .collect(Collectors.toList());
    }
}
