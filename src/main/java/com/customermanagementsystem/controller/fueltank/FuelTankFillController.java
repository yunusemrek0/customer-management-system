package com.customermanagementsystem.controller.fueltank;

import com.customermanagementsystem.payload.request.fueltank.FuelTankFillRequest;
import com.customermanagementsystem.payload.response.fueltank.FuelTankFillResponse;
import com.customermanagementsystem.service.fueltank.FuelTankFillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/fuelTankFill")
@RequiredArgsConstructor
public class FuelTankFillController {

    private final FuelTankFillService fuelTankFillService;


    @PostMapping("/save")
    public ResponseEntity<String> saveFuelTankFill(@Valid @RequestBody FuelTankFillRequest fuelTankFillRequest){
        return ResponseEntity.ok(fuelTankFillService.saveFuelTankFill(fuelTankFillRequest));
    }



    @GetMapping("/getAll")
    public ResponseEntity<List<FuelTankFillResponse>> getAll(){
        return ResponseEntity.ok(fuelTankFillService.getAll());
    }
}
