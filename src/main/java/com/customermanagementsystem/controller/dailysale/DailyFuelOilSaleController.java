package com.customermanagementsystem.controller.dailysale;

import com.customermanagementsystem.payload.request.dailysale.DailyFuelOilSaleRequest;
import com.customermanagementsystem.payload.response.dailysale.DailyFuelOilSaleResponse;
import com.customermanagementsystem.service.dailysale.DailyFuelOilSaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/dailyFuelOilSale")
@RequiredArgsConstructor
public class DailyFuelOilSaleController {

    private final DailyFuelOilSaleService dailyFuelOilSaleService;

    @PostMapping("/save")
    public ResponseEntity<String> saveDailyFuelOilSale(@Valid @RequestBody DailyFuelOilSaleRequest dailyFuelOilSaleRequest){
        return ResponseEntity.ok(dailyFuelOilSaleService.saveDailyFuelOilSale(dailyFuelOilSaleRequest));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<DailyFuelOilSaleResponse>> getAll(){
        return ResponseEntity.ok(dailyFuelOilSaleService.getAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFuelOilSale(@PathVariable Long id){
        return ResponseEntity.ok(dailyFuelOilSaleService.deleteById(id));
    }
}
