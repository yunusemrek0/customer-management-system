package com.customermanagementsystem.controller.customer;

import com.customermanagementsystem.payload.request.customer.LateChargeRequest;
import com.customermanagementsystem.service.customer.LateChargeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/lateCharge")
@RequiredArgsConstructor
public class LateChargeController {

    private final LateChargeService lateChargeService;

    @PostMapping("/save")
    public ResponseEntity<String> saveLateCharge(@Valid @RequestBody LateChargeRequest lateChargeRequest){
        return ResponseEntity.ok(lateChargeService.saveLateCharge(lateChargeRequest));
    }
}
