package com.customermanagementsystem.controller.dailysale;

import com.customermanagementsystem.payload.request.dailysale.BankAndCashRequest;
import com.customermanagementsystem.payload.response.dailysale.BankAndCashResponse;
import com.customermanagementsystem.service.dailysale.CashOrBankTransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/cashDelivery")
@RequiredArgsConstructor
public class CashDeliveryController {

    private final CashOrBankTransferService service;

    @PostMapping("/save")
    public ResponseEntity<String> saveCashDelivery(@Valid @RequestBody BankAndCashRequest request){
        return ResponseEntity.ok(service.saveCashDelivery(request));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<BankAndCashResponse>> getAll(){
        return ResponseEntity.ok(service.getAllCashDelivery());
    }
}
