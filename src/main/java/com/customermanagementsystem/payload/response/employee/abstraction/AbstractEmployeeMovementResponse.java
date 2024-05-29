package com.customermanagementsystem.payload.response.employee.abstraction;

import com.customermanagementsystem.service.helper.LocalDateTimeToDateStringSerializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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

    @JsonSerialize(using = LocalDateTimeToDateStringSerializer.class)
    private LocalDateTime dateTime;

    private String employeeName;

    private Double total;

    private String type;
}
