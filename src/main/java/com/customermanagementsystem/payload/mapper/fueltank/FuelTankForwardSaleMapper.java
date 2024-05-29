package com.customermanagementsystem.payload.mapper.fueltank;


import com.customermanagementsystem.entity.fueltank.FuelTankForwardSale;
import com.customermanagementsystem.payload.request.fueltank.FuelTankForwardSaleRequest;
import com.customermanagementsystem.payload.response.fueltank.FuelTankForwardSaleResponse;
import com.customermanagementsystem.service.helper.DateTimeTranslator;
import com.customermanagementsystem.service.helper.MapperHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FuelTankForwardSaleMapper {

    private final DateTimeTranslator dateTimeTranslator;
    private final MapperHelper mapperHelper;


    public FuelTankForwardSale mapFuelTankForwardSaleReqToForwardSale(FuelTankForwardSaleRequest fuelTankForwardSaleRequest){
        return FuelTankForwardSale.builder()
                .amount(mapperHelper.formatDoubleValue(fuelTankForwardSaleRequest.getAmount()))
                .unitPrice(mapperHelper.formatDoubleValue(fuelTankForwardSaleRequest.getUnitPrice()))
                .total(mapperHelper.formatDoubleValue(fuelTankForwardSaleRequest.getAmount() * fuelTankForwardSaleRequest.getUnitPrice()))
                .dateTime(dateTimeTranslator.parseLocalDateTime())
                .build();
    }

    public FuelTankForwardSaleResponse mapFuelTankForwardSaleToResponse(FuelTankForwardSale fuelTankForwardSale){
        return FuelTankForwardSaleResponse.builder()
                .id(fuelTankForwardSale.getId())
                .productName(fuelTankForwardSale.getProduct().getName())
                .total(fuelTankForwardSale.getTotal())
                .customerName(fuelTankForwardSale.getCustomer().getName())
                .amount(fuelTankForwardSale.getAmount())
                .unitPrice(fuelTankForwardSale.getUnitPrice())
                .dateTime(fuelTankForwardSale.getDateTime())
                .type("TANKER VADELİ SATIŞ")
                .build();
    }
}
