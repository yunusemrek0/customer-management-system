package com.customermanagementsystem.controller.customer;

import com.customermanagementsystem.payload.request.customer.CustomerPaymentRequest;
import com.customermanagementsystem.payload.request.customer.ForwardSaleRequest;
import com.customermanagementsystem.service.customer.ForwardSaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/forwardSale")
@RequiredArgsConstructor
public class ForwardSaleController {

    private final ForwardSaleService forwardSaleService;



    @PostMapping("/save")
    public ResponseEntity<String> saveForwardSale(@Valid @RequestBody ForwardSaleRequest forwardSaleRequest){
        return ResponseEntity.ok(forwardSaleService.saveForwardSale(forwardSaleRequest));
    }



}
