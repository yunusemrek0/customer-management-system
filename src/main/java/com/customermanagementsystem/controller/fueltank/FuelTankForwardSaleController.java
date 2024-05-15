package com.customermanagementsystem.controller.fueltank;

import com.customermanagementsystem.entity.fueltank.FuelTankForwardSale;
import com.customermanagementsystem.payload.request.fueltank.FuelTankFillRequest;
import com.customermanagementsystem.payload.request.fueltank.FuelTankForwardSaleRequest;
import com.customermanagementsystem.payload.response.fueltank.FuelTankForwardSaleResponse;
import com.customermanagementsystem.service.fueltank.FuelTankFillService;
import com.customermanagementsystem.service.fueltank.FuelTankForwardSaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/fuelTankForwardSale")
@RequiredArgsConstructor
public class FuelTankForwardSaleController {

    private final FuelTankForwardSaleService fuelTankForwardSaleService;


    @PostMapping("/save")
    public ResponseEntity<String> saveFuelTankForwardSale(@Valid @RequestBody FuelTankForwardSaleRequest fuelTankForwardSaleRequest){
        return ResponseEntity.ok(fuelTankForwardSaleService.saveFuelTankForwardSale(fuelTankForwardSaleRequest));
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<FuelTankForwardSaleResponse>> getAll(){
        return ResponseEntity.ok(fuelTankForwardSaleService.getAll());
    }
}
