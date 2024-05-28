package com.customermanagementsystem.payload.response.employee;

import com.customermanagementsystem.payload.response.employee.abstraction.AbstractEmployeeMovementResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeExpenseResponse extends AbstractEmployeeMovementResponse {

    private String description;
}
