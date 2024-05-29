package com.customermanagementsystem.payload.request.customer;

import com.customermanagementsystem.payload.request.customer.abstraction.AbstractCustomerMovementRequest;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class LateChargeRequest extends AbstractCustomerMovementRequest {

    private Double total;//*****

}
