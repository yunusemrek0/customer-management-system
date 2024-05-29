package com.customermanagementsystem.payload.request.fueltank;

import com.customermanagementsystem.payload.request.customer.abstraction.AbstractCustomerMovementRequest;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class FuelTankForwardSaleRequest extends AbstractCustomerMovementRequest {


    private Long fuelTankId;

    private Long productId;

    private Double amount;

    private Double unitPrice;

}
