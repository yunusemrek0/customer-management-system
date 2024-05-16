package com.customermanagementsystem.payload.mapper.dailysale;

import com.customermanagementsystem.entity.dailysale.DailyProfit;
import com.customermanagementsystem.payload.response.dailysale.DailyProfitResponse;
import com.customermanagementsystem.service.helper.MapperHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DailyProfitMapper {

    private final MapperHelper mapperHelper;

    public DailyProfitResponse mapDailyProfitToDailyProfitResponse(DailyProfit dailyProfit){
        return DailyProfitResponse.builder()
                .profit(mapperHelper.formatDoubleValue(dailyProfit.getProfit()))
                .dateTime(dailyProfit.getDateTime())
                .totalIncome(mapperHelper.formatDoubleValue(dailyProfit.getTotalIncome()))
                .build();
    }
}
