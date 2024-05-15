package com.customermanagementsystem.payload.request.fueltank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FuelTankSaleRequest {



    private Long fuelTankId;

    private Long productId;

    private Double amount;

    private Double unitPrice;


}
