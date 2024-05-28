package com.customermanagementsystem.payload.request.employee.abstraction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractEmployeeMovementRequest {


    private Long employeeId;


    private Double total;

}
