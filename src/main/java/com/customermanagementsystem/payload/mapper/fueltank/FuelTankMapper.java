package com.customermanagementsystem.payload.mapper.fueltank;

import com.customermanagementsystem.entity.fueltank.FuelTank;
import com.customermanagementsystem.payload.response.fueltank.FuelTankResponse;
import org.springframework.stereotype.Component;

@Component
public class FuelTankMapper {

    public FuelTankResponse mapFuelTankToResponse(FuelTank fuelTank){
        return FuelTankResponse.builder()
                .id(fuelTank.getId())
                .name(fuelTank.getName())
                .amountInside(fuelTank.getAmountInside())
                .build();
    }
}
