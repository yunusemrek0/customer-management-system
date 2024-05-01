package com.customermanagementsystem.controller.dailysale;

import com.customermanagementsystem.payload.request.dailysale.DailyExpenseRequest;
import com.customermanagementsystem.payload.request.dailysale.DailyFuelOilSaleRequest;
import com.customermanagementsystem.payload.response.dailysale.DailyExpenseResponse;
import com.customermanagementsystem.payload.response.dailysale.DailyFuelOilSaleResponse;
import com.customermanagementsystem.service.dailysale.DailyExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/dailyExpense")
@RequiredArgsConstructor
public class DailyExpenseController {

    private final DailyExpenseService dailyExpenseService;


    @PostMapping("/save")
    public ResponseEntity<String> saveDailyExpense(@Valid @RequestBody DailyExpenseRequest dailyExpenseRequest){
        return ResponseEntity.ok(dailyExpenseService.saveDailyExpense(dailyExpenseRequest));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<DailyExpenseResponse>> getAll(){
        return ResponseEntity.ok(dailyExpenseService.getAll());
    }
}
