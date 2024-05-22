package com.customermanagementsystem.controller.customer;

import com.customermanagementsystem.payload.request.customer.CustomerPaymentRequest;
import com.customermanagementsystem.payload.response.customer.CustomerPaymentResponse;
import com.customermanagementsystem.service.customer.CustomerPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/customerPayment")
@RequiredArgsConstructor
public class CustomerPaymentController {

    private final CustomerPaymentService customerPaymentService;


    @PostMapping("/save")
    public ResponseEntity<String> saveCustomer(@Valid @RequestBody CustomerPaymentRequest customerPaymentRequest){
        return ResponseEntity.ok(customerPaymentService.saveCustomerPayment(customerPaymentRequest));
    }


    @GetMapping("/getByCustomer/{customerId}")
    public ResponseEntity<List<CustomerPaymentResponse>> getByCustomer(@PathVariable Long customerId){
        return ResponseEntity.ok(customerPaymentService.getByCustomer(customerId));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CustomerPaymentResponse>> getAll(){
        return ResponseEntity.ok(customerPaymentService.getAll());
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomerPayment(@PathVariable Long id){
        return ResponseEntity.ok(customerPaymentService.deleteById(id));
    }

}
