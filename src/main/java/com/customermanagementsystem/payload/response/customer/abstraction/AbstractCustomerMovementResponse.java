package com.customermanagementsystem.payload.response.customer.abstraction;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class AbstractCustomerMovementResponse {

    private Long id;

    private LocalDateTime dateTime;

    private String productName;

    private Double total;

    private String description;

    private String customerName;

    private Double unitPrice;

    private Double amount;

    private String type;
}
