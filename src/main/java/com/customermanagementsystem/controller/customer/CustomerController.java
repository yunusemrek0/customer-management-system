package com.customermanagementsystem.controller.customer;

import com.customermanagementsystem.payload.request.customer.CustomerRequest;
import com.customermanagementsystem.payload.response.customer.CustomerDetailResponse;
import com.customermanagementsystem.payload.response.customer.CustomerResponse;
import com.customermanagementsystem.service.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;


    @PostMapping("/save")
    public ResponseEntity<String> saveCustomer(@Valid @RequestBody CustomerRequest customerRequest){
        return ResponseEntity.ok(customerService.saveCustomer(customerRequest));
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<String> updateCustomer(@Valid @RequestBody CustomerRequest customerRequest,
                                                 @PathVariable Long id){
        return ResponseEntity.ok(customerService.updateCustomer(customerRequest,id));
    }


    @GetMapping("/getAllByPage")
    public ResponseEntity<Page<CustomerResponse>> getByPage(
            @RequestParam (value = "page", defaultValue = "0") int page,
            @RequestParam (value = "size", defaultValue = "10") int size,
            @RequestParam (value = "sort", defaultValue = "id") String sort,
            @RequestParam (value = "type", defaultValue = "desc") String type
    ){
        return ResponseEntity.ok(customerService.getByPage(page,size,sort,type));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CustomerResponse>> getAll(){
        return ResponseEntity.ok(customerService.getAll());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<CustomerResponse> getById(@PathVariable Long id){
        return ResponseEntity.ok(customerService.getById(id));
    }


    @GetMapping("/getByName/{customerName}")
    public ResponseEntity<List<CustomerResponse>> getByName(@PathVariable String customerName){
        return ResponseEntity.ok(customerService.getByName(customerName));
    }

    @GetMapping("/getDetails/{id}")
    public ResponseEntity<List<CustomerDetailResponse>> getCustomerDetails(@PathVariable Long id){
        return ResponseEntity.ok(customerService.getDetails(id));
    }

    @GetMapping("/getSumOfBalance")
    public ResponseEntity<Double> getTotalSumOfBalance(){
        return ResponseEntity.ok(customerService.getTotalSumOfBalance());
    }



}
