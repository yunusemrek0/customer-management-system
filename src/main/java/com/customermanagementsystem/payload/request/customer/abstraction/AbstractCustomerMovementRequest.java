package com.customermanagementsystem.payload.request.customer.abstraction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractCustomerMovementRequest {

    private Long customerId;

    private String description;


}
