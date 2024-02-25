package com.customermanagementsystem.controller.dailysale;

import com.customermanagementsystem.payload.request.customer.CustomerRequest;
import com.customermanagementsystem.payload.request.dailysale.FuelPompRequestToSave;
import com.customermanagementsystem.payload.request.dailysale.FuelPompRequestToUpdate;
import com.customermanagementsystem.service.dailysale.FuelPompService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/fuelPomp")
@RequiredArgsConstructor
public class FuelPompController {

    private final FuelPompService fuelPompService;


    @PostMapping("/save")
    public ResponseEntity<String> saveFuelPomp(@Valid @RequestBody FuelPompRequestToSave fuelPompRequest){
        return ResponseEntity.ok(fuelPompService.saveFuelPomp(fuelPompRequest));
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<String> updateFuelPomp(@Valid @RequestBody FuelPompRequestToUpdate fuelPompRequest,
                                                 @PathVariable Long id){
        return ResponseEntity.ok(fuelPompService.updateFuelPomp(fuelPompRequest,id));
    }

}
