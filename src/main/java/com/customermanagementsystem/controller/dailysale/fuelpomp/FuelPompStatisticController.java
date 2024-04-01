package com.customermanagementsystem.controller.dailysale.fuelpomp;

import com.customermanagementsystem.payload.response.dailysale.fuelpomp.FuelPompStatisticResponse;
import com.customermanagementsystem.service.dailysale.fuelpomp.FuelPompStatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/fuelPompStatistic")
@RequiredArgsConstructor
public class FuelPompStatisticController {

    private final FuelPompStatisticService fuelPompStatisticService;

    @GetMapping("/getAll")
    public ResponseEntity<List<FuelPompStatisticResponse>> getAll(){

        return ResponseEntity.ok(fuelPompStatisticService.getAll());

    }
}
