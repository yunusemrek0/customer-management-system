package com.customermanagementsystem.payload.mapper.dailysale;

import com.customermanagementsystem.entity.dailysale.DailyExpense;
import com.customermanagementsystem.payload.request.dailysale.DailyExpenseRequest;
import com.customermanagementsystem.payload.response.dailysale.DailyExpenseResponse;
import com.customermanagementsystem.service.helper.DateTimeTranslator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DailyExpenseMapper {

    private final DateTimeTranslator dateTimeTranslator;


    public DailyExpense mapDailyExpenseRequestToDailyExpense(DailyExpenseRequest dailyExpenseRequest){

        return DailyExpense.builder()
                .description(dailyExpenseRequest.getDescription())
                .total(dailyExpenseRequest.getTotal())
                .dateTime(dateTimeTranslator.parseLocalDateTime())
                .build();
    }


    public DailyExpenseResponse mapDailyExpenseToDailyExpenseResponse(DailyExpense dailyExpense){

        return DailyExpenseResponse.builder()
                .id(dailyExpense.getId())
                .dateTime(dailyExpense.getDateTime())
                .total(dailyExpense.getTotal())
                .description(dailyExpense.getDescription())
                .build();
    }


}
