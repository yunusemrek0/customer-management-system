package com.customermanagementsystem.service.helper.dailysale;

import com.customermanagementsystem.entity.dailysale.DailyProfit;
import com.customermanagementsystem.entity.dailysale.DailySale;
import com.customermanagementsystem.repository.dailysale.DailyProfitRepository;
import com.customermanagementsystem.service.helper.DateTimeTranslator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DailyProfitHelper {

    private final DailyProfitRepository dailyProfitRepository;
    private final DateTimeTranslator dateTimeTranslator;


    public void dailyProfitCreator(DailySale dailySale){
        DailyProfit dailyProfit = DailyProfit.builder()
                .profit(dailySale.getTotalFuelOilSales() - dailySale.getTotalFuelOilSalesAsPurchasePrice())
                .totalIncome(dailySale.getTotalIncome())
                .dailySale(dailySale)
                .dateTime(dateTimeTranslator.parseLocalDateTime())
                .build();

        dailyProfitRepository.save(dailyProfit);
    }
}
