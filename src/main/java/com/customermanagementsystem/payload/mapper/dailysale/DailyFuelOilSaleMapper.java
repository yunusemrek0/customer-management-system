package com.customermanagementsystem.payload.mapper.dailysale;


import com.customermanagementsystem.entity.dailysale.DailyFuelOilSale;
import com.customermanagementsystem.payload.request.dailysale.DailyFuelOilSaleRequest;
import com.customermanagementsystem.payload.response.dailysale.DailyFuelOilSaleResponse;
import com.customermanagementsystem.service.helper.DateTimeTranslator;
import com.customermanagementsystem.service.helper.MapperHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DailyFuelOilSaleMapper {

    private final DateTimeTranslator dateTimeTranslator;

    private final MapperHelper mapperHelper;


    public DailyFuelOilSale mapFuelOilSaleRequestToFuelOilSale(DailyFuelOilSaleRequest saleRequest){

        return DailyFuelOilSale.builder()
                .amount(mapperHelper.formatDoubleValue(saleRequest.getAmount()))
                .dateTime(dateTimeTranslator.parseLocalDateTime())
                .build();

    }

    public DailyFuelOilSaleResponse mapFuelOilSaleToFuelOilSaleResponse(DailyFuelOilSale dailyFuelOilSale){
        return DailyFuelOilSaleResponse.builder()
                .id(dailyFuelOilSale.getId())
                .dateTime(dailyFuelOilSale.getDateTime())
                .productName(dailyFuelOilSale.getProduct().getName())
                .amount(mapperHelper.formatDoubleValue(dailyFuelOilSale.getAmount()))
                .build();
    }
}
