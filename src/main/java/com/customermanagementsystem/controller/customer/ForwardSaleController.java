package com.customermanagementsystem.controller.customer;

import com.customermanagementsystem.payload.request.customer.ForwardSaleRequest;
import com.customermanagementsystem.payload.response.customer.ForwardSaleResponse;
import com.customermanagementsystem.service.customer.ForwardSaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/forwardSale")
@RequiredArgsConstructor
public class ForwardSaleController {



    private final ForwardSaleService forwardSaleService;


    @PostMapping("/save")
    public ResponseEntity<String> saveForwardSale(@Valid @RequestBody ForwardSaleRequest forwardSaleRequest){
        return ResponseEntity.ok(forwardSaleService.saveForwardSale(forwardSaleRequest));
    }


    @GetMapping("/getByCustomer/{customerId}")
    public ResponseEntity<List<ForwardSaleResponse>> getByCustomer(@PathVariable Long customerId){
        return ResponseEntity.ok(forwardSaleService.getByCustomer(customerId));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ForwardSaleResponse>> getAll(){
        return ResponseEntity.ok(forwardSaleService.getAll());
    }



}
