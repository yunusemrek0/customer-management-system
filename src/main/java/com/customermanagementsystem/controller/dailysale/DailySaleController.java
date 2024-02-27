package com.customermanagementsystem.controller.dailysale;

import com.customermanagementsystem.payload.request.dailysale.DailySaleRequest;
import com.customermanagementsystem.service.dailysale.DailySaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/dailySale")
@RequiredArgsConstructor
public class DailySaleController {

    private final DailySaleService dailySaleService;


    @PostMapping("/save")
    public ResponseEntity<String> saveDailySale(@Valid @RequestBody DailySaleRequest dailySaleRequest){
        return ResponseEntity.ok(dailySaleService.saveDailySale(dailySaleRequest));
    }
}
