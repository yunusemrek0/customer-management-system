package com.customermanagementsystem.controller.expense;

import com.customermanagementsystem.payload.request.expense.TypeOfExpenseRequest;
import com.customermanagementsystem.payload.response.expense.TypeOfExpenseResponse;
import com.customermanagementsystem.service.expense.TypeOfExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/typeOfExpense")
@RequiredArgsConstructor
public class TypeOfExpenseController {

    private final TypeOfExpenseService typeOfExpenseService;

    @PostMapping("/save")
    public ResponseEntity<String> saveTypeOfExpense(@Valid @RequestBody TypeOfExpenseRequest typeOfExpenseRequest){
        return ResponseEntity.ok(typeOfExpenseService.saveTypeOfExpense(typeOfExpenseRequest));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<TypeOfExpenseResponse>> getAll(){
        return ResponseEntity.ok(typeOfExpenseService.getAll());
    }
}
