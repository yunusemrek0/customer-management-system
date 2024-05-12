package com.customermanagementsystem.controller.dailysale;

import com.customermanagementsystem.payload.response.dailysale.DailyProfitResponse;
import com.customermanagementsystem.service.dailysale.DailyProfitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dailyProfit")
@RequiredArgsConstructor
public class DailyProfitController {

    private final DailyProfitService dailyProfitService;

    @GetMapping("/getAll")
    public ResponseEntity<List<DailyProfitResponse>> getAll(){
        return ResponseEntity.ok(dailyProfitService.getAll());
    }

}
