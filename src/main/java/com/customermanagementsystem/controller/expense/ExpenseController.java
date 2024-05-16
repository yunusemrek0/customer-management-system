package com.customermanagementsystem.controller.expense;

import com.customermanagementsystem.payload.request.expense.ExpenseRequest;
import com.customermanagementsystem.payload.request.expense.TypeOfExpenseRequest;
import com.customermanagementsystem.payload.response.expense.ExpenseResponse;
import com.customermanagementsystem.payload.response.expense.TypeOfExpenseResponse;
import com.customermanagementsystem.repository.expense.ExpenseRepository;
import com.customermanagementsystem.service.expense.ExpenseService;
import com.customermanagementsystem.service.expense.TypeOfExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/expense")
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;

    @PostMapping("/save")
    public ResponseEntity<String> saveExpense(@Valid @RequestBody ExpenseRequest expenseRequest){
        return ResponseEntity.ok(expenseService.saveExpense(expenseRequest));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ExpenseResponse>> getAll(){
        return ResponseEntity.ok(expenseService.getAll());
    }
}
