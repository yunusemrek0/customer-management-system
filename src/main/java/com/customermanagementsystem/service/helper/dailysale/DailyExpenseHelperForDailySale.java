package com.customermanagementsystem.service.helper.dailysale;

import com.customermanagementsystem.entity.dailysale.DailyExpense;
import com.customermanagementsystem.entity.dailysale.DailySale;
import com.customermanagementsystem.repository.dailysale.DailyExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DailyExpenseHelperForDailySale {

    private final DailyExpenseRepository dailyExpenseRepository;

    public List<DailyExpense> getByDailySaleIsNull() {
        return dailyExpenseRepository.getByDailySaleIsNull();
    }

    public double totalDailyExpense(List<DailyExpense> dailyExpenses) {
        double total = 0;

        for (DailyExpense dailyExpense:dailyExpenses){
            total += dailyExpense.getTotal();
        }

        return total;
    }

    public void saveDailySaleForDailyExpense(List<DailyExpense> dailyExpenses, DailySale savedDailySale) {

        for (DailyExpense dailyExpense:dailyExpenses){
            dailyExpense.setDailySale(savedDailySale);
            dailyExpenseRepository.save(dailyExpense);
        }
    }
}
