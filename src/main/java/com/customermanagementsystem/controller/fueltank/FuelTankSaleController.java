package com.customermanagementsystem.controller.fueltank;

import com.customermanagementsystem.payload.request.fueltank.FuelTankSaleRequest;
import com.customermanagementsystem.payload.response.fueltank.FuelTankSaleResponse;
import com.customermanagementsystem.service.fueltank.FuelTankSaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/fuelTankSale")
@RequiredArgsConstructor
public class FuelTankSaleController {

    private final FuelTankSaleService fuelTankSaleService;


    @PostMapping("/save")
    public ResponseEntity<String> saveFuelTankFill(@Valid @RequestBody FuelTankSaleRequest fuelTankSaleRequest){
        return ResponseEntity.ok(fuelTankSaleService.saveFuelTankSale(fuelTankSaleRequest));
    }



    @GetMapping("/getAll")
    public ResponseEntity<List<FuelTankSaleResponse>> getAll(){
        return ResponseEntity.ok(fuelTankSaleService.getAll());
    }
}
