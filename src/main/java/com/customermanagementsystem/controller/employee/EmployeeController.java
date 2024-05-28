package com.customermanagementsystem.controller.employee;


import com.customermanagementsystem.payload.request.employee.EmployeeRequest;
import com.customermanagementsystem.payload.response.employee.EmployeeResponse;
import com.customermanagementsystem.payload.response.employee.abstraction.AbstractEmployeeMovementResponse;
import com.customermanagementsystem.service.employee.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;


    @PostMapping("/save")
    public ResponseEntity<String> saveEmployee(@Valid @RequestBody EmployeeRequest employeeRequest){
        return ResponseEntity.ok(employeeService.saveEmployee(employeeRequest));
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<String> updateEmployee(@Valid @RequestBody EmployeeRequest employeeRequest,
                                                 @PathVariable Long id){
        return ResponseEntity.ok(employeeService.updateEmployee(employeeRequest,id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<EmployeeResponse>> getAll(){
        return ResponseEntity.ok(employeeService.getAll());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<EmployeeResponse> getById(@PathVariable Long id){
        return ResponseEntity.ok(employeeService.getById(id));
    }

    @GetMapping("/getDetails/{id}")
    public ResponseEntity<List<AbstractEmployeeMovementResponse>> getDetails(@PathVariable Long id){
        return ResponseEntity.ok(employeeService.getDetails(id));
    }


}
