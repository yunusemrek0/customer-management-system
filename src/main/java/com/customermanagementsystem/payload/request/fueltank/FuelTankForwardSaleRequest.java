package com.customermanagementsystem.payload.request.fueltank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FuelTankForwardSaleRequest {


    private Long fuelTankId;

    private Long customerId;

    private Long productId;

    private Double amount;

    private Double unitPrice;

}
