package com.customermanagementsystem.payload.mapper.dailysale;

import com.customermanagementsystem.entity.dailysale.DailyProfit;
import com.customermanagementsystem.payload.response.dailysale.DailyProfitResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DailyProfitMapper {

    public DailyProfitResponse mapDailyProfitToDailyProfitResponse(DailyProfit dailyProfit){
        return DailyProfitResponse.builder()
                .profit(dailyProfit.getProfit())
                .dateTime(dailyProfit.getDateTime())
                .totalIncome(dailyProfit.getProfit())
                .build();
    }
}
