package com.customermanagementsystem.payload.mapper.fueltank;

import com.customermanagementsystem.entity.fueltank.FuelTankFill;
import com.customermanagementsystem.payload.request.fueltank.FuelTankFillRequest;
import com.customermanagementsystem.payload.response.fueltank.FuelTankFillResponse;
import com.customermanagementsystem.service.helper.DateTimeTranslator;
import com.customermanagementsystem.service.helper.MapperHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FuelTankFillMapper {

    private final DateTimeTranslator dateTimeTranslator;
    private final MapperHelper mapperHelper;

    public FuelTankFill mapFuelTankFillReqToFuelTankFill(FuelTankFillRequest fuelTankFillRequest){
        return FuelTankFill.builder()
                .dateTime(dateTimeTranslator.parseLocalDateTime())
                .amount(mapperHelper.formatDoubleValue(fuelTankFillRequest.getAmount()))
                .unitPrice(mapperHelper.formatDoubleValue(fuelTankFillRequest.getUnitPrice()))
                .total(mapperHelper.formatDoubleValue(fuelTankFillRequest.getAmount() * fuelTankFillRequest.getUnitPrice()))
                .build();

    }

    public FuelTankFillResponse mapFuelTankFillToFuelTankFillRes(FuelTankFill fuelTankFill){
        return FuelTankFillResponse.builder()
                .id(fuelTankFill.getId())
                .amount(fuelTankFill.getAmount())
                .unitPrice(fuelTankFill.getUnitPrice())
                .productName(fuelTankFill.getProduct().getName())
                .dateTime(fuelTankFill.getDateTime())
                .total(fuelTankFill.getTotal())
                .build();

    }
}
