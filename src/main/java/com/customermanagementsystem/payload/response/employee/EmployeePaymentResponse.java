package com.customermanagementsystem.payload.response.employee;

import com.customermanagementsystem.payload.response.employee.abstraction.AbstractEmployeeMovementResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeePaymentResponse extends AbstractEmployeeMovementResponse {

}
