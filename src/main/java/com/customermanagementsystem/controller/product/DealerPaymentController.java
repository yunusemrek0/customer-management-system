package com.customermanagementsystem.controller.product;

import com.customermanagementsystem.payload.request.employee.EmployeeRequest;
import com.customermanagementsystem.payload.request.product.DealerPaymentRequest;
import com.customermanagementsystem.payload.response.employee.EmployeeResponse;
import com.customermanagementsystem.payload.response.product.DealerPaymentResponse;
import com.customermanagementsystem.service.product.DealerPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/dealerPayment")
@RequiredArgsConstructor
public class DealerPaymentController {

    private final DealerPaymentService dealerPaymentService;

    @PostMapping("/save")
    public ResponseEntity<String> saveDealerPayment(@Valid @RequestBody DealerPaymentRequest dealerPaymentRequest){
        return ResponseEntity.ok(dealerPaymentService.saveDealerPayment(dealerPaymentRequest));
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<DealerPaymentResponse>> getAll(){
        return ResponseEntity.ok(dealerPaymentService.getAll());
    }


}
