package com.customermanagementsystem.controller.dailysale.fuelpomp;

import com.customermanagementsystem.payload.request.dailysale.FuelPompRequestToSave;
import com.customermanagementsystem.payload.request.dailysale.FuelPompRequestToUpdate;
import com.customermanagementsystem.payload.response.dailysale.fuelpomp.FuelPompResponse;
import com.customermanagementsystem.service.dailysale.fuelpomp.FuelPompService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
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

    @GetMapping("/getAll")
    public ResponseEntity<List<FuelPompResponse>> getAll(){
        return ResponseEntity.ok(fuelPompService.getAll());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<FuelPompResponse> getById(@PathVariable Long id){
        return ResponseEntity.ok(fuelPompService.getById(id));
    }

}
