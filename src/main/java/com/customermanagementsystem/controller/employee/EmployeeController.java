package com.customermanagementsystem.controller.employee;


import com.customermanagementsystem.payload.request.customer.CustomerRequest;
import com.customermanagementsystem.payload.request.employee.EmployeeRequest;
import com.customermanagementsystem.payload.response.employee.EmployeeResponse;
import com.customermanagementsystem.service.employee.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;


    @PostMapping("/save")
    public ResponseEntity<String> saveEmployee(@Valid @RequestBody EmployeeRequest employeeRequest){
        return ResponseEntity.ok(employeeService.saveEmployee(employeeRequest));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<EmployeeResponse>> getAll(){
        return ResponseEntity.ok(employeeService.getAll());
    }
}
