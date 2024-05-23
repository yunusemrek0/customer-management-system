package com.customermanagementsystem.controller.employee;

import com.customermanagementsystem.payload.request.employee.EmployeeExpenseRequest;
import com.customermanagementsystem.payload.response.employee.EmployeeExpenseResponse;
import com.customermanagementsystem.service.employee.EmployeeExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/employeeExpense")
@RequiredArgsConstructor
public class EmployeeExpenseController {

    private final EmployeeExpenseService employeeExpenseService;

    @PostMapping("/save")
    public ResponseEntity<String> saveEmployee(@Valid @RequestBody EmployeeExpenseRequest employeeExpenseRequest){
        return ResponseEntity.ok(employeeExpenseService.saveEmployee(employeeExpenseRequest));
    }

    @GetMapping("/getByEmployee/{employeeId}")
    public ResponseEntity<List<EmployeeExpenseResponse>> getByEmployee(@PathVariable Long employeeId){
        return ResponseEntity.ok(employeeExpenseService.getByEmployee(employeeId));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<EmployeeExpenseResponse>> getAll(){
        return ResponseEntity.ok(employeeExpenseService.getAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployeeExpense(@PathVariable Long id){
        return ResponseEntity.ok(employeeExpenseService.deleteById(id));
    }

}
