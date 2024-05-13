package com.customermanagementsystem.controller.dailysale;

import com.customermanagementsystem.payload.request.dailysale.DailySaleBalanceRequest;
import com.customermanagementsystem.payload.request.dailysale.DailySaleRequest;
import com.customermanagementsystem.payload.response.dailysale.DailySaleResponse;
import com.customermanagementsystem.service.dailysale.DailySaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/dailySale")
@RequiredArgsConstructor
public class DailySaleController {

    private final DailySaleService dailySaleService;


    @PostMapping("/save")
    public ResponseEntity<String> saveDailySale(@Valid @RequestBody DailySaleRequest dailySaleRequest){
        return ResponseEntity.ok(dailySaleService.saveDailySale(dailySaleRequest));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<DailySaleResponse>> getAll(){
        return ResponseEntity.ok(dailySaleService.getAll());
    }


    @PostMapping("/findBalance")
    public Double findBalanceBeforeSave(@RequestBody DailySaleBalanceRequest dailySaleRequest){
        return dailySaleService.findBalanceBeforeSave(dailySaleRequest);
    }

}