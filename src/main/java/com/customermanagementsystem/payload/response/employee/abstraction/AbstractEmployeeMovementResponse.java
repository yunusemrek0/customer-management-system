package com.customermanagementsystem.payload.response.employee.abstraction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractEmployeeMovementResponse {

    private Long id;

    private LocalDateTime dateTime;

    private String employeeName;

    private Double total;

    private String type;
}
