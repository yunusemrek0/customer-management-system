package com.customermanagementsystem.payload.mapper.dailysale.fuelpomp;

import com.customermanagementsystem.entity.dailysale.fuelpomp.FuelPompStatistic;
import com.customermanagementsystem.payload.response.dailysale.fuelpomp.FuelPompStatisticResponse;
import com.customermanagementsystem.service.helper.MapperHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FuelPompStatisticMapper {

private final MapperHelper mapperHelper;

    public FuelPompStatisticResponse mapFuelPompStatisticToFuelPompStatisticResponse(FuelPompStatistic fuelPompStatistic){
        return FuelPompStatisticResponse.builder()
                .id(fuelPompStatistic.getId())
                .dateTime(fuelPompStatistic.getDateTime())
                .fuelPompName(fuelPompStatistic.getFuelPomp().getName())
                .amountAsLiter(mapperHelper.formatDoubleValue(fuelPompStatistic.getAmountAsLiter()))
                .total(mapperHelper.formatDoubleValue(fuelPompStatistic.getTotal()))
                .build();
    }
}
