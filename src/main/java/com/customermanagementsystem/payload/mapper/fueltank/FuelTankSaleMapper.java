package com.customermanagementsystem.payload.mapper.fueltank;

import com.customermanagementsystem.entity.fueltank.FuelTankSale;
import com.customermanagementsystem.payload.request.fueltank.FuelTankSaleRequest;
import com.customermanagementsystem.payload.response.fueltank.FuelTankSaleResponse;
import com.customermanagementsystem.service.helper.DateTimeTranslator;
import com.customermanagementsystem.service.helper.MapperHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FuelTankSaleMapper {

    private final DateTimeTranslator dateTimeTranslator;
    private final MapperHelper mapperHelper;

    public FuelTankSale mapFuelTankFillReqToFuelTankFill(FuelTankSaleRequest fuelTankSaleRequest){
        return FuelTankSale.builder()
                .dateTime(dateTimeTranslator.parseLocalDateTime())
                .amount(mapperHelper.formatDoubleValue(fuelTankSaleRequest.getAmount()))
                .unitPrice(mapperHelper.formatDoubleValue(fuelTankSaleRequest.getUnitPrice()))
                .total(mapperHelper.formatDoubleValue(fuelTankSaleRequest.getAmount() * fuelTankSaleRequest.getUnitPrice()))
                .build();

    }

    public FuelTankSaleResponse mapFuelTankFillToFuelTankFillRes(FuelTankSale fuelTankSale){
        return FuelTankSaleResponse.builder()
                .id(fuelTankSale.getId())
                .amount(fuelTankSale.getAmount())
                .unitPrice(fuelTankSale.getUnitPrice())
                .productName(fuelTankSale.getProduct().getName())
                .dateTime(fuelTankSale.getDateTime())
                .total(fuelTankSale.getTotal())
                .build();

    }
}
