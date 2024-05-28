package com.customermanagementsystem.payload.request.employee;

import com.customermanagementsystem.payload.request.employee.abstraction.AbstractEmployeeMovementRequest;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class EmployeeExpenseRequest extends AbstractEmployeeMovementRequest {

    private String description;
}
