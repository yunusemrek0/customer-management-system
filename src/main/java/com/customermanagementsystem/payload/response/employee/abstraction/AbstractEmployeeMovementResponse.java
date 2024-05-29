package com.customermanagementsystem.payload.response.employee.abstraction;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class AbstractEmployeeMovementResponse {

    private Long id;

    private LocalDateTime dateTime;

    private String employeeName;

    private Double total;

    private String type;
}
