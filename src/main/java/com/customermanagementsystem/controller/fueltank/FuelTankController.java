package com.customermanagementsystem.controller.fueltank;

import com.customermanagementsystem.payload.response.fueltank.FuelTankResponse;
import com.customermanagementsystem.service.fueltank.FuelTankService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/fuelTank")
@RequiredArgsConstructor
public class FuelTankController {

    private final FuelTankService fuelTankService;

    @GetMapping("/getAll")
    public ResponseEntity<List<FuelTankResponse>> getAll(){
        return ResponseEntity.ok(fuelTankService.getAll());
    }
}
