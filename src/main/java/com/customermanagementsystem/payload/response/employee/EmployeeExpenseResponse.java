package com.customermanagementsystem.payload.response.employee;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeExpenseResponse {


    private Long id;

    private LocalDateTime dateTime;

    private String employeeName;

    private Double total;

    private String description;
}
