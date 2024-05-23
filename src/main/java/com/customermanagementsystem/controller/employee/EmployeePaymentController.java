package com.customermanagementsystem.controller.employee;

import com.customermanagementsystem.payload.request.employee.EmployeePaymentRequest;
import com.customermanagementsystem.payload.response.employee.EmployeePaymentResponse;
import com.customermanagementsystem.service.employee.EmployeePaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/employeePayment")
@RequiredArgsConstructor
public class EmployeePaymentController {

    private final EmployeePaymentService employeePaymentService;

    @PostMapping("/save")
    public ResponseEntity<String> saveEmployeePayment(@Valid @RequestBody EmployeePaymentRequest employeePaymentRequest){
        return ResponseEntity.ok(employeePaymentService.saveEmployeePayment(employeePaymentRequest));
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<EmployeePaymentResponse>> getAll(){
        return ResponseEntity.ok(employeePaymentService.getAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployeeExpense(@PathVariable Long id){
        return ResponseEntity.ok(employeePaymentService.deleteById(id));
    }
}
